#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

int main()
{
    int await1 = fork();
    if (await1 == 0){
        if (fork() == 0){
            printf("B \n");
            exit(0);
        }
        else
        {
            wait(NULL);
            printf("u \n");
        }
        printf("S \n");
        exit(0);
    }else{
        wait(&await1);
        int await3 = fork(); // makes a child
        int await4 = fork(); // makes 2 children

        if (await4 == 0){
            exit(0);
        }
        if (await3 == 0){
            exit(0);
        }
        wait(NULL);
        printf("20 \n");
        if (fork() == 0){ // makes 4 children
            printf("Zwan \n");
            exit(0);
        }
        wait(NULL);
        printf("Zig \n");
    }
}