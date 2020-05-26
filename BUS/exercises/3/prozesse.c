#include <stdio.h>
#include <unistd.h>

void child_B_proc()
{
  while (1)
  {
    fprintf(stdout, "%s", "C");
    fflush(stdout);
  }
}

void child_A_proc()
{

  while (1)
  {
    fprintf(stdout, "%s", "A");
    fflush(stdout);
  }
}

void parent_proc()
{
  while (1)
  {
    write(1, "B", 1);
  }
}

int main(void)
{
  // follow parent process & continue child A here
  if (fork() == 0)
  {
    // follow child A & continue child B here
    // essentially: spawn B from A and see where we are
    // then execute code accordingly
    if (fork() == 0)
      // execute code for child B
      child_B_proc();
    else
      // execute code for child A
      child_A_proc();
  }
  else
    parent_proc();
  return 0;
}
