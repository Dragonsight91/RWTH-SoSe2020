public class Test2 {

    public static void main (String [] args) {
	
    	int [] x = new int [3];
    	
    	x [0] = 14;
    	x [1] = 2;
    	x [2] = 5;
    
    	int [] y = new int [2];
    
    	y[0] = 3;
    	y[1] = 4;
    
    	y = x;
    	
    	y [1] = 8;
    
    	System.out.println("x [1] = " + x [1]);

    }

}
