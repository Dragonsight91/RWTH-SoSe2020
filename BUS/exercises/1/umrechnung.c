#include <stdio.h>

int main(void)
{
    double k = 1.609; /* Gleitkommakonstante zum Umrechnen */

    printf("| Km | Meilen |\n=====|=========\n");

    for (int i = 0; i <= 20; i++)
    {
        printf("| %2d | %3.2f |\n", i, k * i) ;
    }
    

    return 0;
}
