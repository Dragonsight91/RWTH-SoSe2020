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
#define XOR '%' // xor
#define IMP '@' // implication
#define EQI '=' // equivalence

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
    // allocate some memory of the correct size
    struct node *node = (struct node *)malloc(sizeof(struct node));

    // set the default values
    node->data = '\0';
    node->left = NULL;
    node->right = NULL;

    // return the node
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
        // a score >0 is an open bracket
        // a score == 0 means that no brackets are open
        if (*(eq + i) == '(')
            brck++;
        else if (*(eq + i) == ')')
            brck--;

        // There's a missing operator...
        // luckily there are only few cases, we can just test for all of them
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
            // log the error and exit entirely
            printf("[\e[91mERR\e[0m] Missing Operator Error at index: \e[35m%d\e[0m\n", startpos + i);
            exit(0);
        }

        // See if we do have a proper operator AND no open brackets
        if ((*(eq + i) == OR || *(eq + i) == AND || *(eq + i) == XOR) && (brck == 0))
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

        // set null terminator
        *(partitionA + lenA - 1) = '\0';
        *(partitionB + lenB - 1) = '\0';

        // copy the data over. this adds space complexity, but keeps it easier to read
        strncpy(partitionA, eq, lenA - 1);
        strncpy(partitionB, eq + opIdx + 1, lenB - 1);

        // create the operator nodes
        struct node *a = newNode();
        struct node *b = newNode();

        // save a pointer in our node
        curr->data = *(eq + opIdx);
        curr->left = a;
        curr->right = b;

        // recursively descend further
        parser(a, partitionA, lenA - 1, startpos); // descend into the A side
        free(partitionA); // free the memory we used for the branch

        parser(b, partitionB, lenB - 1, startpos + opIdx + 1); // descend into the B side
        free(partitionB); // free the memory we used for the branch

        // end
        return;
    }
    else
    {

        // a fenced expression
        if ((*eq == '(') & (*(eq + len - 1) == ')'))
        {

            // our new byte length
            int newLen = len - 1;

            // remove brackets
            char *temp = malloc(len);
            *(temp + newLen - 1) = '\0';
            strncpy(temp, eq + 1, newLen - 1);

            // try again
            parser(curr, temp, newLen - 1, startpos + 1);
            free(temp); // free memory after descending
            return;
        }

        // a negated expression
        else if (*(eq) == NOT)
        {
            // create a negation node
            struct node *leaf = newNode();

            // create the string and copy data over
            char *newstr = malloc(len);
            *(newstr + len - 1) = '\0';
            strncpy(newstr, eq + 1, len);

            // set the pointer
            curr->data = '~';
            curr->left = leaf;

            // descend further
            parser(leaf, newstr, len - 1, startpos + 1);
            free(newstr); // free memory after descending

            return;
        }

        // welp, here's something i didn't expect
        else
        {
            // some unexpected error, maybe a trailing newline
            printf("[\e[91mERR\e[0m] Unexpected Error around index \e[35m%d\e[0m while parsing.\n", startpos);
            printf("      Expression: %s\n", eq);
            printf("      Length:     %d\n", len);
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
        // return solved AND expression
        return solver(treeNode->left) && solver(treeNode->right); 
        break;
    case OR:
        // return solved OR expression
        return solver(treeNode->left) || solver(treeNode->right);
        break;
    case NOT:
        // return negated data
        return !solver(treeNode->left);
        break;

    default:
        // return our data converted to an integer
        return (int)treeNode->data - '0';
        break;
    }
}


// main function
int main(void)
{
    // open the file
    char* fname = "boolsche-ausdruecke";
    FILE *fd = fopen(fname, "r");
    long int fsize;

    if(fd == NULL){
        char* cwd = malloc(200);
        getcwd(cwd, 200);
        printf("[\e[91mERR\e[0m] Unexpected Error while opening file: \e[35m%s/%s\e[0m\n", cwd, fname);
        printf("      Please make sure the file is in the same folder.\n");
        free(cwd);
        exit(0);
    }
    // get file size
    fseek(fd, 0, SEEK_END);
    fsize = ftell(fd);
    fseek(fd, 0, SEEK_SET);

    // create a buffer of filesize+200. just in case we overflow with a \0
    // this will be shrunken down later.
    char *buf = malloc(fsize);
    memset(buf, '\0', fsize);

    // in our case, we want the last line.
    // we can assume that this line is the longest for our case, so overwriting the buffer is fine.
    // this shouldn't be used, but it's the 2AM quick 'n dirty hotfix
    char *ptr;
    int n = 0;
    while ((ptr = fgets(buf, fsize, fd)) != NULL)
    {
        // get size and reallocate memory to the correct size. we should only use what we need.
        // we can assume null termination, because we filled the memory with \0. it is impossible to exceed that
        // because any subset of characters is at most our max size
        int len = strlen(buf);
        buf = realloc(buf, len);
        *(buf+len-1) = '\0'; // replace any stray \n with \0

        // create a new node
        struct node *root = newNode();

        // start the parser and log stuff
        printf("\n[\e[93mLOG\e[0m] Parsing word \e[35m%d\e[0m\n", n);
        printf("[\e[93mLOG\e[0m] Word Length: \e[35m%d\e[0m\n", len);
        printf("[\e[93mLOG\e[0m] starting parser...\n");
        parser(root, buf, strlen(buf), 0);
        printf("[\e[93mLOG\e[0m] The Expression was parsed Successfully\n");

        // start the solver
        printf("[\e[93mLOG\e[0m] starting solver...\n");
        int solution = solver(root);
        printf("[\e[34mOUT\e[0m] the solution is: \e[35m%d\e[0m\n", solution);
        
        // reallocate the memory, so we can't exceed the buffer when we repeat
        buf = realloc(buf, fsize);
        memset(buf, '\0', fsize);
        n++;
    }
    return 0;
}
