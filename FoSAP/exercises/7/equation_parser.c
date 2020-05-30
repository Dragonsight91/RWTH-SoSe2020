#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <fcntl.h>

// debug mode
#define DEBUG 0

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
        int lenA = opIdx + 1;
        int lenB = len - opIdx;

        // create the partitions
        char *partitionA = malloc(lenA); // partition a goes up to the operator's index
        char *partitionB = malloc(lenB); // partition b starts after the operator's index

        *(partitionA + lenA - 1) = '\0';
        *(partitionB + lenB - 1) = '\0';

        // copy the data over. this adds space complexity, but keeps it easier to read
        strncpy(partitionA, eq, lenA - 1);
        strncpy(partitionB, eq + opIdx + 1, lenB - 1);

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

        parser(a, partitionA, lenA - 1);
        free(partitionA);

        parser(b, partitionB, lenB - 1);
        free(partitionB);

        curr->data = *(eq + opIdx);
        curr->left = a;
        curr->right = b;

        return;
    }
    else
    {
        if (DEBUG)
        {
            printf("Expression: %s\n", eq);
            printf("no operator\n");
            printf("BOOL: %c\n", *(eq + len - 1));
        }
        // (~1)\0
        if ((*eq == '(') & (*(eq + len - 1) == ')'))
        {
            printf("this is fenced\n");
            // remove fencing
            int newLen = len - 1;
            char *temp = malloc(len);
            *(temp + newLen - 1) = '\0';
            strncpy(temp, eq + 1, newLen - 1);

            if (DEBUG)
                printf("unfenced eq: %s\n", temp);
            // try again
            parser(curr, temp, newLen - 1);
            free(temp);
            return;
        }
        else if (*(eq) == '~')
        {
            printf("negated");
            struct node *leaf = newNode();
            int newlen = len;
            char *newstr = malloc(newlen);
            *(newstr + newlen - 1) = '\0';

            strncpy(newstr, eq + 1, newlen);

            curr->data = '~';
            curr->left = leaf;
            parser(leaf, newstr, newlen - 1);
            free(newstr);
            return;
        }
        else
        {
            printf("Error while parsing.");
            exit(EXIT_FAILURE);
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
    FILE *fd = fopen("boolsche-ausdruecke", "r");
    long int fsize;

    // get file size
    fseek(fd, 0, SEEK_END);
    fsize = ftell(fd);
    fseek(fd, 0, SEEK_SET);

    // create a buffer of filesize+200. just in case we overflow with a \0
    // this will be shrunken down later.
    char *buf = malloc(fsize+200);
    memset(buf, '\0', fsize+200);

    // in our case, we want the last line. 
    // we can assume that this line is the longest for our case, so overwriting the buffer is fine.
    // this shouldn't be used, but it's the 2AM quick 'n dirty hotfix
    char *ptr;
    while ((ptr = fgets(buf, fsize, fd)) != NULL)
    {
        if(ptr != NULL)
            memset(buf, '\0', fsize); // over
    }

    // get size and reallocate memory to the correct size. we should only use what we need.
    // we can assume null termination, because we filled the memory with \0. it is impossible to exceed that
    // because any subset of characters is at most our max size
    int len = strlen(buf);
    buf = realloc(buf, len+1); 

    char *str = "(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))";
    // create a new node
    struct node *root = newNode();

    parser(root, str, strlen(str));
    printf("\nWord Length: %d\n", (int) strlen(str));
    return 0;
}
