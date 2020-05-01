public class Zins_Programm {

    public static double zins (double kapital) {
    	// berechnet 3 Prozent Zinsen
    
    	return 1.03 * kapital;

    }


    public static void main (String [] args) {

    	double betrag1 = 1000,
    	       betrag2 = 570.22,
    
    	       gewinn = zins (betrag1 + betrag2);
    
    	System.out.println (gewinn);

    }

}
	
