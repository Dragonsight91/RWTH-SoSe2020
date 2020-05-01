package test;

import listen.*;
import wert.*;
import wert.zahlen.*;
import wert.zeichen.*;

public class Test_Programm {

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
    	
    	
    	intliste.fuegeVorneEin (new Int(1));
    	intliste.fuegeVorneEin (new Int(0));
    	intliste.fuegeVorneEin (new Int(3));
    
    	intliste.drucke();
    	intliste.druckeRueckwaerts();
    
    	intliste.loesche(new Int(0));
    	intliste.drucke();
    	
    	
    	wortliste.fuegeVorneEin (new Wort("eins"));
    	wortliste.fuegeVorneEin (new Wort("null"));
    	wortliste.fuegeVorneEin (new Wort("drei"));
    
    	wortliste.drucke();
    	wortliste.druckeRueckwaerts();
    
    	wortliste.loesche(new Wort("null"));
    	wortliste.drucke();
	
    }

}
