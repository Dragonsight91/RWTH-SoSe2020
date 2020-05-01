package listen;

import wert.Vergleichbar;

/** Datentyp fuer Elemente einer linearen Liste, deren Werte 
 *  verglichen werden koennen.
 * @see Liste
 * @see Vergleichbar
 * @author Juergen Giesl
 */
class Element {
    
    Vergleichbar wert;
    Element next; //Element ist eine rekursive Datenstruktur.
    
    /** erzeugt ein neues Element ohne Nachfolger.
     *   @param wert Wert, den das neue Element erhalten soll
     */
    Element (Vergleichbar wert) {
    	this.wert = wert;
    	next = null;
    }
    
    /** erzeugt ein neues Element mit Nachfolger.
     *   @param wert Wert, den das neue Element erhalten soll
     *   @param next Nachfolgerelement des neuen Elements
     */
    Element (Vergleichbar wert, Element next) {
    	this.wert = wert;
    	this.next = next;
    }
    
    /** @return Wert des Elements
     */
    Vergleichbar getWert () {
    	return wert;
    }
    
    /** @param wert Wert, den das Element erhalten soll
     */	
    void setWert (Vergleichbar wert) {
    	this.wert = wert;
    }
    /** @return Nachfolger des Elements
     */
   Element getNext () {
       	return next;
    }
    
    /** @param next Nachfolger, den das Element erhalten soll
     */	
    void setNext (Element next) {
    	this.next = next;
    }
    
    

}




