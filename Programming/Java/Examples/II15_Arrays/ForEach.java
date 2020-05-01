public class ForEach{


    public static void main (String [] args) {
	int [] a = {0, 1, 2, 3};

	for (int i = 0; i < a.length; i++) { 
	    int x = a[i]; 
	    
	    System.out.print(x);
	    
	}	
	
	for (int x : a) {
	    
	    System.out.print(x);
	    
	}	

    }

}
