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

struct restaurant_s
{
    pid_t pid[MAX_PROCESSES]; /*  PIDs of child processes */
    sem_t free_space_inside;  /* this is the actual bouncer */
    int customers_in_queue;
    int customers_in_restaurant;
};

int shouldEnd = 0; /* to terminate while-loop */

void signal_handler(int signalNum)
{
    printf("Owner: Got interrupted, will shutdown the restaurant now \n");
    shouldEnd = 1;
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

    /* shar_mem->free_space_inside ist eine Zählsemaphore die angibt, wieviel Platz im Restaurant ist
     *
     * Am Anfang kann sie also MAX_CUSTOMERS viele Leute reinlassen
     * Was wäre also ein guter start Wert? Wann blockt die Semaphore?
     *
     * Achtung: shar_mem->free_space_inside ist die Semaphore um zu zählen, wieviele Leute im Club sind,
     * sie sichert nicht den gemeinsamen Speicherbereich (shar_mem), dazu benötigen Sie eine 2. unbenannte
     * Semaphore, die sie noch anlegen müssen.
     */

    /* initialize random number generator */
    srand(time(NULL));

    /* catch interrupts */
    signal(SIGINT, signal_handler);

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
            shar_mem->customers_in_queue++;

            /* create the new customer */
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

                if (/* nach 2 Sekunden immer noch nicht im Restaurant, hier muss also noch eine passende Bedingung hin */ 0)
                {
                    printf("%d: That takes too long, I leave\n", getpid());
                    for (int i = 0; i < MAX_PROCESSES; i++)
                    {
                        if (shar_mem->pid[i] == getpid())
                        {
                            shar_mem->pid[i] = -1;
                            break;
                        }
                    }
                    shar_mem->customers_in_queue--;
                }
                else
                {
                    /* we are in, so we leave the queue */
                    shar_mem->customers_in_queue--;
                    shar_mem->customers_in_restaurant++;

                    /* stay here some time to eat - yummy!!! */
                    printf("%d: YUMMY YUM - Delicious! \n", getpid());
                    usleep(((rand() % 5000) + 3000) * 1000);
                    printf("%d: I am full - I go home now\n", getpid());

                    shar_mem->customers_in_restaurant--;

                    for (int i = 0; i < MAX_PROCESSES; i++)
                    {
                        if (shar_mem->pid[i] == getpid())
                        {
                            shar_mem->pid[i] = -1;
                            break;
                        }
                    }
                }
                /* exit, this causes a SIGCHLD at the parent process */
                exit(0);
            }
            else
            {
                /* Root process prints queue size and joined customer
                         * root process now knows about the child processes currently running */
                shar_mem->pid[free_slot] = f_pid;

                printf("Owner: %d joined the queue, there are %d people in the queue and %d in the restaurant \n",
                       f_pid, shar_mem->customers_in_queue, shar_mem->customers_in_restaurant);
            }
        }

        /* delay everything a bit between 300 and 800 ms */
        usleep(((rand() % 501) + 300) * 1000);
    }

    /* ok we should end here so wait for all children to terminate */
    printf("Owner: Close the kitchen, wait for customers to leave\n");

    for (int i = 0; i < MAX_PROCESSES; i++)
    {
        if (shar_mem->pid[i] != -1)
        {
            waitpid(shar_mem->pid[i], NULL, 0);
        }
    }

    /* detach shared memory */
    shmdt(shar_mem);
    /* remove shared memory identifier */
    shmctl(id, IPC_RMID, 0);

    return 0;
}