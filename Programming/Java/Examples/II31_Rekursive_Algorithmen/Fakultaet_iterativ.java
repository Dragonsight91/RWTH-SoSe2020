public class Fakultaet_iterativ {

    public static int fak (int x) {
    
    	int res = 1;
    
    	while (x > 1) {
        
    	    res = x * res;
    	    x = x - 1;
    
    	}
    
    	return res;

    }

    
    public static void main (String [] args) {
    
    	int x = SimpleIO.getInt("Bitte geben Sie eine Zahl ein: ");
    	SimpleIO.output("Fakultaet von " + x + " ist " + fak(x),"Ergebnis");

    }
    
}
