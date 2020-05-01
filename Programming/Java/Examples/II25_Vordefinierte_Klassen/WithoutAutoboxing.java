public class WithoutAutoboxing {
 

    public static void main (String [] args) {
    	
    	Integer x = Integer.valueOf(321);
    	int i = x.intValue();
    	Integer y = Integer.valueOf(x.intValue() + 2);
    	Double z = Double.valueOf(Math.sqrt(y.intValue()));
    	//Double d = Integer.valueOf(4);
    	Double d = Double.valueOf(4);
    	Double e = Double.valueOf(4.0);
    
    	System.out.println("x = " + x + ", i = " + i + ", y = " + y + ", z = " + z + ", d = " + d + ", e = " + e);

    }

}
