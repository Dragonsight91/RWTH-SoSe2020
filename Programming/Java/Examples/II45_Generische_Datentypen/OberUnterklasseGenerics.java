public class OberUnterklasseGenerics {

    public static void main (String [] args) {

    	Liste <A> aList = new Liste <> ();
    	Liste <B> bList = new Liste <> ();
      
    	// aList = bList; //fuehrt zu Typfehler beim Compilieren
    
    	aList.fuegeVorneEin(new C ());
    }

}