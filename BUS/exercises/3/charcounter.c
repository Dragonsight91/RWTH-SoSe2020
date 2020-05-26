#include <stdio.h>
#include <unistd.h>
#define BUFFERLEN 6000
int main(void)
{
    char buffer[BUFFERLEN];
    int a = 0;
    int b = 0;
    int c = 0;

    double percentagea = 0;
    double percentageb = 0;
    double percentagec = 0;

    // main loop
    while (1)
    {
        sleep(10);
        a = 0;
        b = 0;
        c = 0;
        fgets(buffer, BUFFERLEN, stdin);
        for (int i = 0; i < BUFFERLEN; i++)
        {
            if (buffer[i] == 'A')
            {
                a++;
            }
            else if (buffer[i] == 'B')
            {
                b++;
            }
            else
            {
                c++;
            }
        }

        percentagea = ((double)a / (a + b + c)) * 100;
        percentageb = ((double)b / (a + b + c)) * 100;
        percentagec = ((double)c / (a + b + c)) * 100;
        printf("Occurence of A: %d, B: %d, C: %d. \n In percent: \n  A: \e[36m%.3f\e[0m %% \n  B: \e[36m%.3f\e[0m %% \n  C: \e[36m%.3f\e[0m %%\n", a, b, c, percentagea, percentageb, percentagec);
    }
}