public class OberUnterklasseArrays {

    public static void main (String [] args) {
    
    	A [] aArray = new A [5];
    	B [] bArray = new B [17];
      
    	aArray = bArray;
    
    	// aArray[0] = new C (); // compiliert, aber fuehrt zu Typfehler zur Laufzeit
    }

}