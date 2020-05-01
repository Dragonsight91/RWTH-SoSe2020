public class Listen_Programm {

    public static void main (String [] args) {
    	
    	Liste <Bruch> bruchliste = new Liste <>  ();
    	Liste <Wort> wortliste = new Liste <> ();
    
    	bruchliste.fuegeVorneEin (new Bruch(9,6));
    	bruchliste.fuegeVorneEin (new Bruch(1,2));
    	bruchliste.fuegeVorneEin (new Bruch(25,7));
    	
    	bruchliste.drucke();
    	bruchliste.druckeRueckwaerts();
    
    	bruchliste.loesche(new Bruch(6,12));
    	bruchliste.drucke();
    	
    	System.out.println(bruchliste.suche(new Bruch(50,14)));
    
    
    	wortliste.fuegeVorneEin (new Wort("eins"));
    	wortliste.fuegeVorneEin (new Wort("null"));
    	wortliste.fuegeVorneEin (new Wort("drei"));
    
    	wortliste.drucke();
    	wortliste.druckeRueckwaerts();
    
    	wortliste.loesche(new Wort("null"));
    	//wortliste.loesche(new Bruch(9,6)); fuehrt jetzt zu Typfehler
    	wortliste.drucke();
    	
    	System.out.println(wortliste.suche(new Wort("drei")));

    }

}
