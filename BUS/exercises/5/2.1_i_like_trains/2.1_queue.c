#include <stdio.h>
#include <semaphore.h>
#include <unistd.h>
#include <pthread.h>
#include "2.1_list.h"

#define LIST_MAX 10
#define THREAD_COUNT 5;
sem_t dequ;
sem_t enqu;

void enqueue(list *queue, element *elem)
{
    sem_wait(&dequ);

    add(queue, elem);

    int sem_val;
    sem_getvalue(&dequ, &sem_val);
    printf("\nSemaphore value: %d\n", sem_val);
    printf("added: %d\n", elem->value);
    printList(queue);

    sem_post(&enqu);
}

element *dequeue(list *queue)
{   
    element *elem = rem(queue);
    if(elem==NULL)
        sem_wait(&enqu);
    

    int sem_val;
    sem_getvalue(&dequ, &sem_val);
    printf("\nSemaphore value: %d\n", sem_val);
    printList(queue);
    
    sem_post(&dequ);

    return elem;
}

// thread functions
void* addStuff(void *queue)
{
    for (int i = 0; i < 100; i++)
    {
        element *new = newElem(i);
        enqueue(queue, new);
    }
    return 0;
}
void* remStuff(void *queue){
    for (int i = 0; i < 102; i++)
    {
        element *elem = dequeue(queue);
        free(elem);
    }
    return 0;
}

int main(void)
{
    sem_init(&dequ, 0, LIST_MAX);
    sem_init(&enqu, 0, -1);
    list *queue = newList();

    pthread_t thread1, thread3;

    pthread_create(&thread1, NULL, addStuff, queue);
    pthread_create(&thread3, NULL, remStuff, queue);

    pthread_join(thread1, NULL);
    pthread_join(thread3, NULL);

    return 0;
}