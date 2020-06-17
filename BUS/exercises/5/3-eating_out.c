#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/wait.h>
#include <semaphore.h>
#include <errno.h>
#include <string.h>
#include <time.h>
#include <signal.h>

#define MAX_CUSTOMERS 8
#define MAX_QUEUE_LENGTH 10
#define MAX_PROCESSES (MAX_CUSTOMERS + MAX_QUEUE_LENGTH)
#define MASK_MIN 3
#define MASK_MAX 5

struct restaurant_s
{
    pid_t pid[MAX_PROCESSES]; /*  PIDs of child processes */
    sem_t free_space_inside;  /* this is the actual bouncer */
    sem_t shsync;            // memory sync semaphore 
    sem_t masks;             // mask counter semaphore
    pid_t waiter;            // waiter PID, only needs one
    int customers_in_queue;
    int customers_in_restaurant;
};

int shouldEnd = 0; /* to terminate for-loop */
int8_t run = 1;    // waiter run variable. we only need a bit, this can never overflow, so why use more than 8 bit? 

// handle SIGINT in root
void signal_handler(int signalNum)
{
    printf("Owner: Got interrupted, will shutdown the restaurant now \n");
    shouldEnd = 1;
}

// handle SIGINT in waiter
void waiter_exit(int signalNum)
{
    printf("Waiter: Going home. \n");
    run = 0;
}

int main(int argc, char **argv)
{
    int id, free_slot; /* "id" of Shared Memory Segment
                  change value stored in shared memory with *shar_mem */
    struct restaurant_s *shar_mem;
    pid_t f_pid; /* the pid after fork (customer pid) */

    /* request shared memory segment (get), attach to process (shmat), and set to 0 */
    id = shmget(IPC_PRIVATE, sizeof(struct restaurant_s), IPC_CREAT | 0644);
    shar_mem = (struct restaurant_s *)shmat(id, 0, 0);
    memset(shar_mem, 0, sizeof(struct restaurant_s));

    /* initialize pids to -1, i.e. not in restaurant */
    for (int i = 0; i < MAX_PROCESSES; i++)
    {
        shar_mem->pid[i] = -1;
    }

    /* shar_mem->free_space_inside ist eine Zaehlsemaphore die angibt, wieviel Platz im Restaurant ist
     *
     * Am Anfang kann sie also MAX_CUSTOMERS viele Leute reinlassen
     * Was waere also ein guter start Wert? Wann blockt die Semaphore?
     *
     * Achtung: shar_mem->free_space_inside ist die Semaphore um zu zaehlen, wieviele Leute im Club sind,
     * sie sichert nicht den gemeinsamen Speicherbereich (shar_mem), dazu benoetigen Sie eine 2. unbenannte
     * Semaphore, die sie noch anlegen muessen.
     */

    /* initialize random number generator */
    srand(time(NULL));

    // initialize semaphores
    sem_init(&shar_mem->masks, 1, 0); // a counter semaphore, there are no masks available, no one has a mask
    sem_init(&shar_mem->shsync, 1, 1); // a mutex, only one process is allowed to write at a time
    sem_init(&shar_mem->free_space_inside, 1, MAX_CUSTOMERS); // the free space semaphore. it's just the amount of customers that fits

    /* catch interrupts */
    signal(SIGINT, signal_handler);

    // create the waiter and save its PID in shared memory
    if ((shar_mem->waiter = fork()) == 0)
    {
        // handle the SIGINT
        signal(SIGINT, waiter_exit);
        printf("Waiter: arriving at restaurant\n"); // waiter was created
        int sleep;

        int masks; // the random amount of masks

        // run as long as no SIGINT was sent
        while (run)
        {
            masks = ((random() % 3)+3) ; // generate a random integer between 3 and 5
            sleep = ((rand() % 3001) + 6000)*1000; // sleep time in microseconds

            // we only give masks, if there are enough people in the cueue, otherwise we give masks to nonexistent people
            if (shar_mem->customers_in_queue >= masks)
            {
                // print status
                printf("Waiter: Handing out %d masks\n", masks);

                // hand out 3-5 masks
                for (size_t i = 0; i < masks; i++) // 1 iq, 3 masks; (1%3)-3 = 0
                {
                    sem_post(&shar_mem->masks);
                }
                usleep(sleep); // sleep for 3-6 seconds
            }
        }
        exit(0); // exit
    }

    printf("Waiter PID: %d\n", shar_mem->waiter); // doesn't need sync, we are in root and it is only written once

    // root process
    while (!shouldEnd)
    {
        /* we are exclusive now */
        if (shar_mem->customers_in_queue < MAX_QUEUE_LENGTH)
        {
            /* there is space for at least one more */
            for (free_slot = 0; free_slot < MAX_PROCESSES; free_slot++)
            {
                if (shar_mem->pid[free_slot] == -1)
                {
                    break;
                }
            }

            /* enque customer in line */
            // synchronize memory access. 
            sem_wait(&shar_mem->shsync);
            shar_mem->customers_in_queue++;
            sem_post(&shar_mem->shsync);

            /* create the new customer */
            // stack variables don't need to be threadsafe
            f_pid = fork();
            if (f_pid == 0)
            {
                /* this is the customer code (child) */
                struct timespec tv;

                /* childs should not catch SIG_INT */
                signal(SIGINT, SIG_DFL);
                srand(time(NULL));

                /* Check if we can enter the restaurant within 2 seconds */
                /* requires absolute time */
                clock_gettime(CLOCK_REALTIME, &tv);
                tv.tv_sec += 2;
                tv.tv_nsec = 0;

                // a value of -1 means that it had an error. as there is no reason for an error other tan a timeout
                // we can assume that we caught that. 
                if (sem_timedwait(&shar_mem->free_space_inside, &tv) == -1)
                {

                    printf("%d: That takes too long, I leave\n", getpid());

                    for (int i = 0; i < MAX_PROCESSES; i++)
                    {
                        if (shar_mem->pid[i] == getpid())
                        {
                            sem_wait(&shar_mem->shsync);
                            shar_mem->pid[i] = -1;
                            sem_post(&shar_mem->shsync);
                            break;
                        }
                    }

                    sem_wait(&shar_mem->shsync);
                    shar_mem->customers_in_queue--;
                    sem_post(&shar_mem->shsync);
                }
                else
                {
                    /* we are in, so we leave the queue */
                    printf("%d: Waiing for mask \n", getpid());
                    sem_wait(&shar_mem->masks);
                    printf("%d: Going inside \n", getpid());

                    sem_wait(&shar_mem->shsync);
                    shar_mem->customers_in_queue--;
                    shar_mem->customers_in_restaurant++;
                    sem_post(&shar_mem->shsync);

                    /* stay here some time to eat - yummy!!! */
                    printf("%d: YUMMY YUM - Delicious! \n", getpid());
                    usleep(((rand() % 5000) + 3000) * 1000);
                    printf("%d: I am full - I go home now\n", getpid());

                    sem_wait(&shar_mem->shsync);
                    shar_mem->customers_in_restaurant--;
                    sem_post(&shar_mem->shsync);

                    for (int i = 0; i < MAX_PROCESSES; i++)
                    {
                        if (shar_mem->pid[i] == getpid())
                        {
                            sem_wait(&shar_mem->shsync);
                            shar_mem->pid[i] = -1;
                            sem_post(&shar_mem->shsync);

                            break;
                        }
                    }

                    // we have to free the space after we leave
                    sem_post(&shar_mem->free_space_inside);
                }
                /* exit, this causes a SIGCHLD at the parent process */
                exit(0);
            }
            else
            {
                /* Root process prints queue size and joined customer
                         * root process now knows about the child processes currently running */
                sem_wait(&shar_mem->shsync);
                shar_mem->pid[free_slot] = f_pid;
                sem_post(&shar_mem->shsync);

                printf("Owner: %d joined the queue, there are %d people in the queue and %d in the restaurant \n",
                       f_pid, shar_mem->customers_in_queue, shar_mem->customers_in_restaurant);
            }
        }

        /* delay everything a bit between 300 and 800 ms */
        usleep(((rand() % 501) + 300) * 1000);
    }

    /* ok we should end here so wait for all children to terminate */
    printf("Owner: Close the kitchen, wait for customers to leave\n");

    // destroy the masks semaphore and stop all processes from waiting for masks.
    sem_destroy(&shar_mem->masks);

    for (int i = 0; i < MAX_PROCESSES; i++)
    {
        if (shar_mem->pid[i] != -1)
        {
            printf("%d: Going Home\n", shar_mem->pid[i]);
            waitpid(shar_mem->pid[i], NULL, 0);
        }
    }

    // wait for the waiter to close
    waitpid(shar_mem->waiter, NULL, 0);

    /* detach shared memory */
    shmdt(shar_mem);
    /* remove shared memory identifier */
    shmctl(id, IPC_RMID, 0);

    return 0;
}