#include <stdio.h>
#include <semaphore.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/shm.h>
#include <signal.h>
#include <string.h>
#include <pthread.h>
#include "2.1_list.h"

#define LIST_MAX 10
#define THREAD_COUNT 5


sem_t enqu;
sem_t dequ;
sem_t sync_proc;
list *queue;
int run = 1; 


void enqueue(element *elem)
{
    sem_wait(&enqu); // see if we can add

    sem_wait(&sync_proc);  // sync_prochronize write
    add(queue, elem); 
    printList(queue);
    sem_post(&sync_proc);

    sem_post(&dequ); // we have added, dequeue can now happen
}

element *dequeue(list *queue)
{
    sem_wait(&dequ); // see if we can remove

    sem_wait(&sync_proc); // sync_prochronize read
    element *elem = rem(queue);
    printList(queue);
    sem_post(&sync_proc);

    sem_post(&enqu);

    return elem;
}

void *addStuff(void* args)
{
    while(run){
        srand(time(NULL));
        element *new = newElem(rand());
        enqueue(new);
    }
    return 0;
}
void *remStuff(void * args)
{
    while(run){
        element *elem = dequeue(queue);
        
        free(elem);
    }
    return 0;
}

int main(void)
{
    // i didn't expect to have to do shared memory handling... 
    int id;

    srand(time(NULL));

    sem_init(&dequ, 1, LIST_MAX);
    sem_init(&enqu, 1, 0);
    sem_init(&sync_proc, 1, 1);

    queue = newList();

    pthread_t p1, p2, p3;

    pthread_create(&p1, NULL, addStuff, NULL);
    pthread_create(&p2, NULL, remStuff, NULL);
    pthread_create(&p3, NULL, addStuff, NULL);

    pthread_join(p1, NULL);
    pthread_join(p2, NULL);
    pthread_join(p3, NULL);

    return 0;
}