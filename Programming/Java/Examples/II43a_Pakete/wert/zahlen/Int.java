package wert.zahlen;

import io.*;
import wert.*;

/** Klasse fuer ganze Zahlen
 *  @author Juergen Giesl
 */
public class Int extends Zahl {


    /** Attribute fuer den Zaehler und den Nenner des Bruchs
     */
    private int ganzeZahl;

    /** generiert eine ganze Zahl durch Eingabe des Benutzers
     */
    public Int () {
    	aenderung();
    }
   


    /** generiert eine vorgegebene ganze Zahl
     *  @param ganzeZahl die vorgegebene ganze Zahl
     */
    public Int (int ganzeZahl) {

    	this.ganzeZahl = ganzeZahl;

     }

    /** liest eine ganze Zahl von der Tastatur ein
     *  und aendert die aktuelle Zahl entsprechend
     */
    public void aenderung () {

    	ganzeZahl = SimpleIO.getInt("Eingabe der Zahl");
    }




    /** vergleicht zwei Zahlen nach ihrem Wert.
     *  @param zuvergleichen das Objekt Int, mit dem die 
     *         aktuelle Zahl verglichen werden soll
     *  @return true, falls die beiden Int-Zahlen inhaltlich gleich sind und sonst false;
     *   falls "zuvergleichen" kein Int ist, wird eine Fehlermeldung ausgegeben und 
     *   das Ergebnis ist ebenfalls false.
     */
    public boolean gleich (Vergleichbar zuvergleichen) {

    	Int b;
    
    	if (zuvergleichen instanceof Int) {
    	    b = (Int) zuvergleichen;
    	    return (ganzeZahl == b.ganzeZahl);
    	}
    	else {
    	    System.out.println ("Es wurden keine Int-Objekte verglichen.");
    	    return false;
    	}

    }

    /** gibt die ganze Zahl zurueck.
     *  @return die gekapselte ganze Zahl
     */
    public int runde () {

    	return ganzeZahl;

    }

    /** ueberfuehrt die ganze Zahl in einen String.
     *  @return String der Zahl
     */

    public String toString () {
	
    	return Integer.toString(ganzeZahl);

    }

}
