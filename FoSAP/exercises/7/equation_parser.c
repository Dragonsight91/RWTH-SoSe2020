#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>

// debug mode
#define DEBUG 1

//  Parser Symbol definitions

// basic operators
#define NOT '~'
#define OR '|'
#define AND '&'

// compound operators (TODO: IMPLEMENT)
#define XOR '%'
#define IMP '@'
#define EQI '='

//struct definitions
struct node
{
    char data;
    struct node *left;
    struct node *right;
};

// create a new node
struct node *newNode()
{

    struct node *node = (struct node *)malloc(sizeof(struct node));

    node->data = '\0';
    node->left = NULL;
    node->right = NULL;

    return node;
}

void parser(struct node *curr, char *eq, int len)
{
    printf("\nlength: %d\n", len);
    if (len == 0)
        return;

    if (len == 1)
    {
        curr->data = *eq;
        printf("Symbol: %c\n", *eq);
        return;
    }

    // keep track of our position
    int opIdx = -1; // the operand index. this is the location of any given operand in the statement
    int brck = 0;   // the currently opened brackets. if it's not 0, we can't look further, because the algorithm can't parse it.

    // bracket parsing. if there's an equation that has brackets on the outside, we recurse with no action.
    // this is very inefficient, since we have to match and count brackets...
    for (int i = 0; i < len; i++)
    {
        // match either ( or )
        if (*(eq + i) == '(')
            brck++;
        else if (*(eq + i) == ')')
            brck--;

        // see if we have a two-sided operator
        if ((*(eq + i) == OR || *(eq + i) == AND) && (brck == 0))
        {
            opIdx = i;
            if (DEBUG)
                printf("found operator: %c\n", *(eq + opIdx));
            break; // we don't continue, we parse LTR
        }
    }

    // we have some operator index. an operator at 0 is an error.
    if (opIdx != -1)
    {
        // set te length of the partitions
        int lenA = opIdx+1;
        int lenB = len - opIdx;

        // create the partitions
        char *partitionA = malloc(lenA); // partition a goes up to the operator's index
        char *partitionB = malloc(lenB); // partition b starts after the operator's index

        *(partitionA + lenA) = '\0';
        *(partitionB + lenB) = '\0';

        // copy the data over. this adds space complexity, but keeps it easier to read
        strncpy(partitionA, eq, lenA-1);
        strncpy(partitionB, eq+opIdx+1, lenB-1);

        // print the partitions to stdout. DEBUG ONLY!!!
        if (DEBUG)
        {
            printf("Expression: %s\n", eq);
            printf("partition A: %d\n", lenA);
            printf("partition B: %d\n", lenB);
        }

        // assign the operator
        struct node *a = newNode();
        struct node *b = newNode();
    
        parser(a, partitionA, lenA-1);
        free(partitionA);

        parser(b, partitionB, lenB-1);
        free(partitionB);

        curr->data = *(eq + opIdx);
        curr->left = a;
        curr->right = b;

        return;
    }
    else
    {
        printf("Expression: %s\n", eq);
        printf("no operator\n");
        printf("BOOL: %c\n", *(eq + len-1));

        // (~1)\0
        if ((*eq == '(') & (*(eq + len-1) == ')'))
        {
            printf("this is fenced\n");
            // remove fencing
            char* temp = malloc(len-1);
            *(temp + len-1) = '\0';
            strncpy(temp, eq+1, len-2);

            printf("unfenced eq: %s\n", temp);
            // try again
            parser(curr, temp, len-2);
            free(temp);
            return;
        }
        else if (*(eq) == '~')
        {
            printf("negated");
            struct node *leaf = newNode();
            int newlen = len - 1;
            char *newstr = malloc(newlen);

            strncpy(newstr, eq + 1, newlen);

            curr->data = '~';
            curr->left = leaf;
            parser(leaf, newstr, newlen);
            free(newstr);
            return;
        }
        else
        {
            printf("Error while parsing.");
            return;
        }
    }
}

int solver(void)
{
    return 0;
}

void eqBuilder(char **out, struct node **curr)
{
}

int main(void)
{
    FILE* fh = fopen("boolsche-ausdruecke", "r");
    struct node *root = newNode();
    char *test = "(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))";
    int len = strlen(test);
    

    printf("Expression: %s\n\n", test);

    parser(root, test, len);
    printf("\nWord Length: %d\n", len);
    return 0;
}