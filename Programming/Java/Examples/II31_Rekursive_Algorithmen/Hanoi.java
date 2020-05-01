public class Hanoi {
    
    
    private static void bewegeTurm (int hoehe, String von, String ueber, String nach) {
    	
    	if (hoehe > 0) {
    	    bewegeTurm (hoehe-1, von, nach, ueber);
    	    druckeZug  (hoehe, von, nach);
    	    bewegeTurm (hoehe-1, ueber, von, nach);
    	}
	
    }
    
    private static void druckeZug (int hoehe, String von, String nach) {
    	
    	System.out.println ("Scheibe " + hoehe + " von " + von + " nach " + nach);
    	
    }
    
    
    
    public static void main (String [] args) {
    	
    	bewegeTurm(Integer.parseInt(args[0]), "ALPHA", "DELTA", "OMEGA");
    	
    }
    
}
