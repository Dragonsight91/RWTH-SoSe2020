#include <limits.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

/**
 * Struktur, die Eintraege des Stacks kapselt.
 */
typedef struct StackNode
{
    // Zeiger auf den Command-String
    char *command;

    // Zeiger auf den naechsten Knoten des Stacks
    struct StackNode *next_node;
} StackNode;

/**
 * Erstellt einen neuen Knoten des Stacks und haengt ihn am Anfang an
 * Gibt den neuen Startknoten zurück.
 */
StackNode *newNode(char *command)
{
    // allokiere neuen Speicherplatz für den naechsten Knoten auf dem Heap
    StackNode *node = (StackNode *)malloc(sizeof(StackNode));
    node->command = command;
    node->next_node = NULL;
    return node;
}

/**
 * Teste, ob Stack leer ist
 */
bool isEmpty(StackNode *root)
{
    // Falls root auf NULL zeigt, ist der Stack leer
    return !root;
}

/**
 * Fuege einen neuen Knoten dem Stack hinzu.
 */
void push(StackNode **pointer2root, char *command)
{
    // YOUR SOLUTION GOES HERE ...
    if (*pointer2root == NULL)
    {
        *pointer2root = newNode(command); // just set a new node, there is nothing on the stack
    }
    else
    {
        StackNode *temp = newNode(command); // get a new node
        temp->next_node = *pointer2root;    // move node pointer
        *pointer2root = temp;               // move root pointer
    }
}

/**
 * Gib den obersten Knoten zurueck und loesche diesen vom Stack (inklusive Speicherplatzfreigabe)
 */
bool pop(StackNode **pointer2root, char **pointer2command)
{
    // YOUR SOLUTION GOES HERE ...
    if (*pointer2root == NULL)
    {
        return false; // nothing on the stack
    }
    else
    {
        StackNode *temp = *pointer2root; // get current stack element
        StackNode *next_node = temp->next_node; // get next root pointer
        *pointer2command = temp->command; // set command pointer

        *pointer2root = next_node; // move root pointer
        free(temp); // free memory
        return true; // something was indeed popped off
    }
}

int main()
{
    StackNode *root = NULL;

    push(&root, "create: grades.txt");
    push(&root, "add: Max Mustermann 1.0");
    push(&root, "delete: grades.txt");

    char *command;

    while (pop(&root, &command))
    {
        printf("'%s' popped from stack \n", command);
    }

    printf("Stack is empty. Exit \n");

    return 0;
}
