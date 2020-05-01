public class Fakultaet_rekursiv {

    public static int fak (int x) {
    	
    	if (x > 1) return x * fak (x - 1);
    	else       return 1;
	
    }
    
    
    public static void main (String [] args) {
    	        
    	int x = SimpleIO.getInt("Bitte geben Sie eine Zahl ein: ");
    	SimpleIO.output("Fakultaet von " + x + " ist " + fak(x),"Ergebnis");
	
    }
    
}
