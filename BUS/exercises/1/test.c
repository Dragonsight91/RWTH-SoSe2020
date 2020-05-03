#include <stdio.h>

int main(int argc, char const *argv[])
{
    char data[] = "BuK Zero";
    int A[][3] = {{3, 4, 2}, {2, 3, 2}};
    char *z;
    int i = 1;
    int *pi;

    z = data + 4;
    *(data+4) = 'H';
    data[2] = 's';
    pi = &i;
    z = &data[*A[1]] - *pi;

    // z = &data[A[1][0]] - *pi;
    // z = &data[2] - 1;
    // z = *data + 1;


    return 0;
}
