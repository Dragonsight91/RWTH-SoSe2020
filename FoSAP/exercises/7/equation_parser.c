#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>

// debug mode
#define DEBUG 1

//  Parser Symbol definitions

// basic operators 
#define NOT  '~'
#define OR   '|'
#define AND  '&'

// compound operators (TODO: IMPLEMENT)
#define XOR  '%'
#define IMP  '@'
#define EQI  '='

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
        int lenA = opIdx;
        int lenB = len - opIdx-1;

        // create the partitions
        char* partitionA = malloc(lenA+1); // partition a goes up to the operator's index
        char* partitionB = malloc(lenB+1); // partition b starts after the operator's index

        *(partitionA+lenA+1) = '\0';
        *(partitionB+lenB+1) = '\0';

        // copy the data over. this adds space complexity, but keeps it easier to read
        strncpy(partitionA, eq, opIdx);
        strncpy(partitionB, eq + opIdx + 1, len-1);
        

        // print the partitions to stdout. DEBUG ONLY!!!
        printf("Expression: %s\n", eq);
        printf("partition A: %s\n", partitionA);
        printf("partition B: %s\n", partitionB);

        // assign the operator
        struct node *a = newNode();
        struct node *b = newNode();

        // fork the process, so we can use async computation
        pid_t PID = fork();
        if (PID == 0)
        {
            // create a new node

            parser(a, partitionA, lenA);
            exit(0); // clean exit the child
        }
        else
        {
            parser(b, partitionB, lenB);
        }

        // wait for all children to finish, no zombie children allowed
        wait(NULL);

        curr->data = *(eq+opIdx);
        curr->left = a;
        curr->right = b;

        return;
    }
    else
    {
        printf("Expression: %s\n", eq);
        printf("no operator\n");

        // somehow it doesn't work.... WHY?
        if ((*eq == '(') & (*(eq+len-1) == ')'))
        {
            printf("this is fenced\n");
            // remove fencing
            char temp[strlen(eq)-1];
            *(temp+(strlen(eq)-1)) = '\0';
            strncpy(temp, eq+1, len-2);

            printf("unfenced eq: %s\n", temp);
            // try again
            parser(curr, temp, strlen(temp));
        }else if (*(eq) == '~')
        {
            printf("negated");
            struct node* leaf = newNode();
            int newlen = len-1;
            char* newstr = malloc(newlen);

            strncpy(newstr, eq+1, newlen);

            curr->data = '~';
            curr->left = leaf;
            parser(leaf, newstr, newlen);
            
        }else{
            printf("Error while parsing.");
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
    struct node *root = newNode();
    char *test = "~1|(1|0&(0))&1";
    int len = strlen(test);

    printf("Expression: %s\n\n", test);

    parser(root, test, len);

    return 0;
}