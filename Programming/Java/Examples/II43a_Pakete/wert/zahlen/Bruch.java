package wert.zahlen;


import io.*;
import wert.*;

/** Klasse fuer rationale Zahlen in Bruchdarstellung.
 *  @author Juergen Giesl
 */
public class Bruch extends Zahl {


    /** Attribute fuer den Zaehler und den Nenner des Bruchs
     */
    private int zaehler, nenner;

    /** generiert einen Bruch durch Eingabe des Benutzers
     */
    public Bruch () {
    	aenderung();
    }
   


    /** generiert einen Bruch mit vorgegebenem Zaehler und Nenner. Falls der vorgegebene
     *  Nenner 0 ist, wird jedoch der Benutzer nach neuen Werten fuer Zaehler und Nenner
     *  gefragt.
     *  @param zaehler der Zaehler des neuen Bruchs
     *  @param nenner  der Nenner des neuen Bruchs
     */
    public Bruch (int zaehler, int nenner) {
    
    	this.zaehler = zaehler;
    	this.nenner = nenner;	
    	
    	if (nenner == 0) {
    	    System.out.println("Unzulaessiger Bruch!");
    	    aenderung ();
    	}
    	
    }

   /** liest einen Bruch von der Tastatur ein
     *  und aendert den aktuellen Bruch entsprechend
     */
    public void aenderung () {
        
            zaehler = SimpleIO.getInt("Eingabe des Zaehlers");
            	
        
            do {
                nenner = SimpleIO.getInt("Eingabe des Nenners");
                if (nenner == 0) System.out.println ("Der Nenner darf nicht 0 sein.");
            }
            while (nenner == 0);

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

    /** rundet den aktuellen Bruch auf die naechstkleinere ganze Zahl ab.
     *  @return die abgerundete ganze Zahl
     */
    public int runde () {

    	return zaehler / nenner;

    }

    /** ueberfuehrt den Bruch in einen String.
     *  @return String des Bruchs sowie Information ueber die naechstkleinere
     *          ganze Zahl
     */

    public String toString () {
	
    	return zaehler + "/" + nenner + " (" + rundungsinformation() + ")";

    }

}
