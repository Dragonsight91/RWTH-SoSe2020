public class Addiere {

    public static int addiere (int... args) {
    	int x = 0;
    	for (int i : args) 
    	    x += i;
    	return x;
    }

    public static void main (String [] args) {
	
    	System.out.println("addiere (2,3,4) ergibt " + addiere (2,3,4));
    	System.out.println("addiere () ergibt " + addiere ());
    	System.out.println("addiere (new int [] {2,3,4}) ergibt " + addiere (new int [] {2,3,4}));

    }

}
