#include <stdlib.h>

/*
    This is a simple non-threadsafe implementation of a double linked list
    it should have decent performance due to the modular pointer structure
*/
typedef struct element // create the list element
{
    int value;
    struct element *next;
    struct element *prev;
} element;

typedef struct list
{
    element *last;
    element *root;
} list; // pointer to the first list element or NULL

list *newList()
{
    list *new = malloc(sizeof(list));
    new->root = NULL;
    new->root = NULL;
    return new;
}
element *newElem(int val)
{

    // allocate memory
    element *elem = malloc(sizeof(element));

    // init element
    elem->value = val;
    elem->next = NULL;
    elem->prev = NULL;

    // return element
    return elem;
}

void add(list *list, element *elem)
{
    // test
    if (list->last == NULL)
    {
        list->root = elem;
        list->last = elem;
    }
    else
    {
        elem->prev = (list->last);
        (list->last)->next = elem;
        list->last = elem;
    }
}

element *rem(list *list)
{
    if (list->root != NULL)
    {

        element *out = list->root;
        list->root = (list->root)->next;
        return out;
    }
    else
    {
        return list->root;
    }
}

void printList(list *list)
{
    element *curr = list->root;
    if(curr)
    {
        printf("List: ");
        while (curr)
        {

            printf("%d, ", curr->value);

            curr = curr->next;
        }
        printf("\n");
    }else
        printf("List is empty\n");
}