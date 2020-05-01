public class Fak2 {


    public static int fak (int x) throws NegativeNumberException, TooBigNumberException {
	
       if (x < 0) throw new NegativeNumberException(x);
       if (x > 12) throw new TooBigNumberException(x);
       
       if (x > 1) return x * fak (x - 1);
       else       return 1;
   }
       
    
    public static void main (String [] args) {
	
    	int x = SimpleIO.getInt("Bitte Zahl eingeben");
    	
    	try{
    	    System.out.println ("Fakultaet von " + x + " ist " + fak(x));
    	}
    	catch (NegativeNumberException nne) {
    	    System.out.println ("Fehler! Die eingegebene Zahl " + nne.getValue() + " ist negativ.");
    	}
    	catch (Exception e) {
    	    System.out.println ("Fehler! Es trat die folgende Ausnahme auf: " + e );
    	}	    

    }
    
}
