#include <stdio.h>
#include <limits.h>

/* Definition von globalen Variablen.
 * Diese Variablen koennen ueberall im Programm veraendert werden.
 */
int min = INT_MIN;
int array[10] = {4, 6, 2, 0, 9, 1, 5, 7, 8, 3};
int anz = sizeof(array) / sizeof(*array);

/* Diese Funktion vergleicht und sortiert die beiden Feldeintraege
   "i1" und "i2" im Array "array".
 */
void exchange(int i1, int i2)
{
    if (array[i1] < array[i2])
    {
        if (array[i1] < min)
            min = array[i1];
    }
    else
    {
        if (array[i2] < min)
            min = array[i2];
        int *tmp = &array[i1];
        array[i1] = array[i2];
        array[i2] = *tmp;
    }
}

int main()
{
    for (int i = 1; i < anz; ++i)
    {
        for (int j = i + 1; j < anz; ++j)
            exchange(i, j);
    }

    printf("Die Zahlen in sortierter Reihenfolge:");
    for (int i = 0; i < anz; ++i)
        printf(" %d", array[i]);

    printf("\nDas Minimum: %f\n", min);

    return 0;
}