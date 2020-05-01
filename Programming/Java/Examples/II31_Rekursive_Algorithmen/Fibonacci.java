public class Fibonacci {
    
    public static int fib (int x) {
    	
    	if      (x < 1)   return 0;
    	else if (x == 1)  return 1;
    	else              return fib (x - 1) + fib (x - 2);
    	
    }
    
    
    public static void main (String [] args) {
	
           
    	int x = SimpleIO.getInt("Bitte geben Sie eine Zahl ein: ");
    	SimpleIO.output("Die " + x + ". Fibonacci-Zahl ist " + fib(x),"Ergebnis");
	
	
    }
    
}
