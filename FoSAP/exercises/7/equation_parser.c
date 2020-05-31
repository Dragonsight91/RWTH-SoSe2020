#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <stdarg.h>

// debug mode
#define DEBUG 0

// Parser Symbol definitions
// these keep the program modular and expandable

// basic operators
#define NOT '~'
#define OR '|'
#define AND '&'

// compound operators (TODO: IMPLEMENT)
#define XOR '%'
#define IMP '@'
#define EQI '='

// struct definitions
// any expression is like a bool tree, so let's generate one.
// this makes the program output reversible.
// expression -> tree; tree -> expression
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

// parse the expression and create
void parser(struct node *curr, char *eq, int len, int startpos)
{
    // The expression is empty. The only case when that happens is a double operator
    if (len == 0)
    {
        printf("[\e[91mERR\e[0m] Empty Expression Error at: \e[35m%d\e[0m\n", startpos);
        exit(0);
    }

    if (len == 1)
    {
        curr->data = *eq;
        //printf("Symbol: %c\n", *eq);
        return;
    }

    // keep track of our position
    int opIdx = -1; // the operand index. this is the location of any given operand in the statement
    int brck = 0;   // the currently opened brackets. if it's not 0, we can't look further, because the algorithm can't parse it.

    // bracket parsing. if there's an equation that has brackets on the outside, we recurse with no action.
    // this is very inefficient, since we have to match and count brackets...
    // but we have to start somewhere
    for (int i = 0; i < len; i++)
    {
        // match either ( or )
        if (*(eq + i) == '(')
            brck++;
        else if (*(eq + i) == ')')
            brck--;

        // There's a missing operator...
        // luckily there are only few cases
        if (
            (*(eq + i) == '1' && *(eq + i + 1) == '1') ||
            (*(eq + i) == '0' && *(eq + i + 1) == '0') ||
            (*(eq + i) == '1' && *(eq + i + 1) == NOT) ||
            (*(eq + i) == '0' && *(eq + i + 1) == NOT) ||
            (*(eq + i) == ')' && *(eq + i + 1) == NOT) ||
            (*(eq + i) == ')' && *(eq + i + 1) == '0') ||
            (*(eq + i) == ')' && *(eq + i + 1) == '1') ||
            (*(eq + i) == ')' && *(eq + i + 1) == '('))
        {
            printf("[\e[91mERR\e[0m] Missing Operator Error at index: \e[35m%d\e[0m\n", startpos + i);
            exit(0);
        }

        // See if we do have a proper operator AND no open brackets
        if ((*(eq + i) == OR || *(eq + i) == AND) && (brck == 0))
        {

            opIdx = i; // set the operator's index
            break; // we don't continue, we found the operator.
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

        // assign the operator
        struct node *a = newNode();
        struct node *b = newNode();

        // recursively descend further
        // TODO: use multithreading?
        parser(a, partitionA, lenA - 1, startpos);
        free(partitionA); // free the memory we used for the branch

        parser(b, partitionB, lenB - 1, startpos + opIdx + 1);
        free(partitionB); // free the memory we used for the branch

        // save a pointer in our node
        curr->data = *(eq + opIdx);
        curr->left = a;
        curr->right = b;

        return;
    }
    else
    {

        // a fenced expression
        if ((*eq == '(') & (*(eq + len - 1) == ')'))
        {

            // remove fencing
            int newLen = len - 1;
            char *temp = malloc(len);
            *(temp + newLen - 1) = '\0';
            strncpy(temp, eq + 1, newLen - 1);

            // try again
            parser(curr, temp, newLen - 1, startpos + 1);
            free(temp);
            return;
        }

        // a negated expression
        else if (*(eq) == NOT)
        {
            struct node *leaf = newNode();
            int newlen = len;
            char *newstr = malloc(newlen);
            *(newstr + newlen - 1) = '\0';

            strncpy(newstr, eq + 1, newlen);

            curr->data = '~';
            curr->left = leaf;

            // descend further
            parser(leaf, newstr, newlen - 1, startpos + 1);
            free(newstr);

            return;
        }

        // welp, here's something i didn't expect
        else
        {
            printf("[\e[91mERR\e[0m] Unexpected Error around index \e[35m%d\e[0m while parsing.\n", startpos);
            exit(0);
        }
    }
}

// solver function, this really explains itself
int solver(struct node *treeNode)
{
    switch (treeNode->data)
    {
    case AND:
        return solver(treeNode->left) && solver(treeNode->right); // 
        break;
    case OR:
        return solver(treeNode->left) || solver(treeNode->right); // return solved OR expression
        break;
    case NOT:
        return !solver(treeNode->left); // return negated data
        break;

    default:
        return (int)treeNode->data - '0'; // return our data converted to an integer
        break;
    }
}


// main function
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
    char *buf = malloc(fsize + 200);
    memset(buf, '\0', fsize + 200);

    // in our case, we want the last line.
    // we can assume that this line is the longest for our case, so overwriting the buffer is fine.
    // this shouldn't be used, but it's the 2AM quick 'n dirty hotfix
    char *ptr;
    while ((ptr = fgets(buf, fsize, fd)) != NULL)
    {
    }

    // get size and reallocate memory to the correct size. we should only use what we need.
    // we can assume null termination, because we filled the memory with \0. it is impossible to exceed that
    // because any subset of characters is at most our max size
    int len = strlen(buf);
    buf = realloc(buf, len + 1);

    char *str = "(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))&(~1&~~0|1|0&~0&0|0&1&1|~0&(0))&((~(~0)|0&0|1&0|1))|0&1&(~((~(1|~((1))&1&(0))))|(1))|~0&(~0|0|~0|1&1)&(~0&1|0)&0|1&0|1&0&(~1|~1&~1&0)|~0|0|1&0|0|(~(1)&((0|1|~~0|0|(1)&(1&(0)))))";
    //char *str = "~(1&(1&0))";

    // create a new node
    struct node *root = newNode();

    // start the parser
    printf("[\e[93mLOG\e[0m] Word Length: %d\n", (int)strlen(str));
    printf("[\e[93mLOG\e[0m] starting parser...\n");
    parser(root, str, strlen(str), 0);
    printf("[\e[93mLOG\e[0m] The Expression was parsed Successfully\n");

    printf("[\e[93mLOG\e[0m] starting solver...\n");
    int solution = solver(root);

    printf("[\e[34mOUT\e[0m] the solution is: %d\n", solution);
    return 0;
}
