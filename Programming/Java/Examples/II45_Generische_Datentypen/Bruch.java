/** Klasse fuer rationale Zahlen in Bruchdarstellung.
 *  @author Juergen Giesl
 */
public class Bruch implements Vergleichbar {


    /** Attribute fuer den Zaehler und den Nenner des Bruchs
     */
    private int zaehler, nenner;

    


    /** generiert einen Bruch mit vorgegebenem Zaehler und Nenner. Falls der vorgegebene
     *  Nenner 0 ist, wird jedoch der Benutzer nach neuen Werten fuer Zaehler und Nenner
     *  gefragt.
     *  @param zaehler der Zaehler des neuen Bruchs
     *  @param nenner  der Nenner des neuen Bruchs
     */
    public Bruch (int zaehler, int nenner) {

    	this.zaehler = zaehler;
    	this.nenner = nenner;	
	
    }


   /** vergleicht zwei Brueche nach ihrem Wert.
     *  @param zuvergleichen das Objekt Bruch, 
     *         mit dem der aktuelle Bruch verglichen werden soll
     *  @return true, falls die beiden Brueche inhaltlich gleich sind und sonst false;
     *   falls "zuvergleichen" kein Bruch ist, wird eine Fehlermeldung ausgegeben und 
     *   das Ergebnis ist ebenfalls false.
     */
    public boolean gleich (Vergleichbar zuvergleichen) {

    	Bruch b;
    
    	if (zuvergleichen instanceof Bruch) {
    	    b = (Bruch) zuvergleichen;
    	    return (zaehler * b.nenner == b.zaehler * nenner);
    	}
    	else {
    	    System.out.println ("Es wurden keine Brueche verglichen.");
    	    return false;
    	}

    }

    /** ueberfuehrt den Bruch in einen String.
     *  @return String des Bruchs sowie Information ueber die naechstkleinere
     *          ganze Zahl
     */

    public String toString () {
	
    	return zaehler + "/" + nenner;

    }

}
