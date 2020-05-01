package wert.zeichen;

import wert.Vergleichbar;

/** Klasse fuer Worte
 *  @author Juergen Giesl
 */
public class Wort implements Vergleichbar {


    private String zeichenkette;


    /** generiert eine vorgegebene Zeichenkette
     *  @param zeichenkette die vorgegebene Zeichenkette
     */
    public Wort (String zeichenkette) {
	
    	this.zeichenkette = zeichenkette;

    }

        
    /** vergleicht zwei Worte, wobei Gross- und Kleinschreibung ignoriert wird
     *  @param zuvergleichen das Wort, mit dem das aktuelle Wort verglichen werden soll
     *  @return true, falls die beiden Worte bis auf Gross- und Kleinschreibung
     *   gleich sind und sonst false;
     *   falls "zuvergleichen" kein Wort ist, wird eine Fehlermeldung ausgegeben und 
     *   das Ergebnis ist ebenfalls false.
     */
    public boolean gleich (Vergleichbar zuvergleichen) {

    	Wort w;
    
    	if (zuvergleichen instanceof Wort) {
    	    w = (Wort) zuvergleichen;
    	    return zeichenkette.equalsIgnoreCase(w.zeichenkette);
    	}
    	else {
    	    System.out.println ("Es wurden keine Worte verglichen.");
    	    return false;
    	}

    }

    public String toString () {
	
    	return zeichenkette;

    }


}
