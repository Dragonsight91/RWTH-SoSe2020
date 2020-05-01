public class Sort {



    /**  Sortierprozedur.
     *   Nach Ausfuehrung ist a sortiert.
     */
    public static void sortiere (int [] a) {
	
    	for (int i = 0; i < a.length - 1; i ++)
    	    
    	    //Vertausche a[i] mit kleinstem Nachfolger
    	    for (int j = i+1; j < a.length; j++)
    		
        		if (a[i] > a[j]) { //Nachfolger kleiner als a[i]?
        
        		    //Vertausche a[i] und a[j]
        		    int z = a[i];
        		    a[i] = a[j];
        		    a[j] = z;
        		}

    }
    
    
    /** Druckprozedur.
     *  Gibt alle Werte in a aus.
     */
    public static void drucke (int [] a) {

    	for (int i = 0; i < a.length; i++)
    	    System.out.print(a[i] + " ");
    	
    	System.out.print("\n");
    }

    
    public static void main (String [] args) {
	
    	int[] x = new int [4];
    	x[0] = 5; x[1] = 2; x[2] = 7; x[3] = 4;
    	
    	drucke (x);
    	sortiere (x);
    	drucke (x);

    }

}
