public class Huellklassen_Programm {
    
    public static void main (String [] args) {
    	
    	Integer x = Integer.valueOf(321);
    	Integer y = Integer.valueOf("321");
    	int z = Integer.parseInt("321");   
    	
    	String s1 = Integer.toString(321);
    	String s2 = x.toString();
    	
    	System.out.println("x: " + x);
    	System.out.println("y: " + y);
    	System.out.println("z: " + z);
    	System.out.println("s1: " + s1);
    	System.out.println("s2: " + s2);
    	
    	System.out.println ("x == y: " + (x == y));
    	System.out.println ("x.equals(y): " + x.equals(y));
    	
    	System.out.println ("x.intValue() == z : " + (x.intValue () == z));
    	
    }
    
}
