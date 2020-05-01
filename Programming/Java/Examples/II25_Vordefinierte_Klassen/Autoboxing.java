public class Autoboxing {
 

    public static void main (String [] args) {
	
    	Integer x = 321;
    	int i = x;
    	Integer y = x + 2;
    	Double z = Math.sqrt(y);
    	//Double d = 4;
    	Double d = Double.valueOf(4);
    	Double e = 4.0;
    
    	System.out.println("x = " + x + ", i = " + i + ", y = " + y + ", z = " + z + ", d = " + d + ", e = " + e);

    }

}
