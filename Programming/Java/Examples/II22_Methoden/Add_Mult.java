public class Add_Mult {

    public static int add_mult (int y, int... args) {
    	int x = 0;
    	for (int i : args) 
    	    x += i;
    	return x * y;
    }

   public static void main (String [] args) {
	
    	System.out.println("add_mult (2,3,4) ergibt " + add_mult (2,3,4));
    	System.out.println("add_mult (2) ergibt " + add_mult (2));

    }





}