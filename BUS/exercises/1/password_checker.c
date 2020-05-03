#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

// 10 characters + '\0'
#define BUFFER_SIZE 11

int main(void)
{
    char *password_input = malloc(BUFFER_SIZE * sizeof(char));

    // we set access to true when the user is authorized
    bool *access = malloc(sizeof(bool));
    *access = false;

    // SOLUTION
    printf("%p\n", password_input);
    printf("%p\n", access);

    printf("\n Enter the password: \n");

    scanf("%s", password_input);

    if (strcmp(password_input, "BuS20_Hero"))
    {
        printf("\n Wrong Password \n");
    }
    else
    {
        printf("\n Correct Password \n");
        *access = true;
    }

    if (*access)
    {
        printf("\n Root privileges given to the user. !!!DANGER ZONE!!!\n");
    }

    return 0;
}