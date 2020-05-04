#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

// 10 characters + '\0'
#define BUFFER_SIZE 11

int main(void)
{
    // [===========]
    char *password_input = malloc(BUFFER_SIZE * sizeof(char));

    // bool *access = malloc(sizeof(bool));
    // *access = false;
    // [===========][=]

    // SOLUTION
    printf("%p\n", password_input);

    printf("\n Enter the password: \n");

    scanf("%s", password_input);
    // 1. [===========[=]=======] char overwrites boolean
    // 2. [=====================] BOOLEAN NEVER CREATED

    bool *access = malloc(sizeof(bool));
    *access = false;
    printf("%p\n", access);

    // [===========[=]] boolean overwrites char


    // input filter
    char testInput[BUFFER_SIZE] = "";
    for(int i = 0; i < BUFFER_SIZE-1; i++){
        *(testInput + i) = *(password_input + i);
    }     
    *(testInput + BUFFER_SIZE) = '\0';


    printf("Password Given: %s\n", testInput);

    if (strcmp(testInput, "BuS20_Hero"))
    {
        printf("\n Wrong Password \n");
    }
    else
    {
        printf("\n Correct Password \n");
        *access = true;
    }

    if(*access == true){
        printf("\n Root privileges given to the user. !!!DANGER ZONE!!!\n");
    }

    return 0;
}