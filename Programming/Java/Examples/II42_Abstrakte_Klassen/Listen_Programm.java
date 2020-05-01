public class Listen_Programm {

    public static void main (String [] args) {
    	
    	Liste bruchliste = new Liste ();
    	Liste intliste = new Liste ();
    	Liste wortliste = new Liste ();
    	
    	bruchliste.fuegeVorneEin (new Bruch(9,6));
    	bruchliste.fuegeVorneEin (new Bruch(1,2));
    	bruchliste.fuegeVorneEin (new Bruch(25,7));
    
    	bruchliste.drucke();
    	bruchliste.druckeRueckwaerts();
    
    	bruchliste.loesche(new Bruch(6,12));
    	bruchliste.drucke();
    	
    	System.out.println(bruchliste.suche(new Bruch(50,14)));
    
    	intliste.fuegeVorneEin (new Int(1));
    	intliste.fuegeVorneEin (new Int(0));
    	intliste.fuegeVorneEin (new Int(3));
    
    	intliste.drucke();
    	intliste.druckeRueckwaerts();
    
    	intliste.loesche(new Int(0));
    	//intliste.loesche(new Bruch(6,12)); fuehrt nicht zu Typfehler
    	intliste.drucke();
    	
    	System.out.println(intliste.suche(new Int(3)));
    
    	wortliste.fuegeVorneEin (new Wort("eins"));
    	wortliste.fuegeVorneEin (new Wort("null"));
    	wortliste.fuegeVorneEin (new Wort("drei"));
    
    	wortliste.drucke();
    	wortliste.druckeRueckwaerts();
    
    	wortliste.loesche(new Wort("null"));
    	//wortliste.loesche(new Int(0)); fuehrt nicht zu Typfehler
    	wortliste.drucke();
    	
    	System.out.println(wortliste.suche(new Wort("drei")));

    }

}
