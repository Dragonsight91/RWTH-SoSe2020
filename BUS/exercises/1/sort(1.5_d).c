#include <stdio.h>
#include <limits.h>

/* 
    Diese Funktion vergleicht und sortiert die beiden Feldeintraege
   "i1" und "i2" im Array "array".
*/
void exchange(int *array, int i1, int i2)
{
    if (*(array + i2) < *(array + i1))
    {
        int temp = *(array + i2);

        *(array + i2) = *(array + i1);
        *(array + i1) = temp;
    }
}

int main()
{

    /* Definition von globalen Variablen.
    *  Diese Variablen koennen ueberall im Programm veraendert werden.
    */


    int min = INT_MAX; // ths is always greater than everything, except for INT_MAX
    int array[100] = {223, 25, 7, 35, 38, 117, 24, 88, 24, 114, 168, 32, 2, 221, 133, 30, 223, 191, 207, 224, 116, 141, 172, 23, 219, 5, 55, 0, 104, 24, 162, 190, 48, 232, 97, 167, 66, 214, 15, 185, 20, 63, 127, 96, 253, 232, 33, 176, 208, 166, 70, 46, 90, 23, 140, 237, 68, 133, 166, 249, 167, 114, 238, 119, 126, 34, 147, 68, 219, 20, 65, 30, 46, 231, 16, 62, 78, 159, 207, 208, 7, 162, 73, 178, 41, 111, 234, 221, 47, 26, 116, 9, 212, 241, 46, 73, 155, 112, 110, 236};
    int anz = sizeof(array) / sizeof(*array);

    for (int i = 0; i < anz; ++i)
    {
        for (int j = i + 1; j < anz; ++j)
            exchange(array, i, j);
    }

    // smallest number in array is the first, we already sorted it
    min = *array;

    printf("Die Zahlen in sortierter Reihenfolge:\n");
    for (int i = 0; i < anz; ++i)
    {
        printf(" %3i", array[i]);
        if (((i + 1) % 10 == 0) & (i > 0))
            printf("\n");
    }
    printf("\n\nDas Minimum: %i\n", min);

    return 0;
}