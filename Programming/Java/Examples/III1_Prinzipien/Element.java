/** Datentyp fuer Elemente einer linearen Liste, deren Werte 
 *  verglichen werden koennen.
 * @see Liste
 * @see Vergleichbar
 * @author Juergen Giesl
 */
public class Element {
    
    Vergleichbar wert;
    Element next; //Element ist eine rekursive Datenstruktur.
    
    /** erzeugt ein neues Element ohne Nachfolger.
     *   @param wert Wert, den das neue Element erhalten soll
     */
    public Element (Vergleichbar wert) {
	this.wert = wert;
	next = null;
    }
    
    /** erzeugt ein neues Element mit Nachfolger.
     *   @param wert Wert, den das neue Element erhalten soll
     *   @param next Nachfolgerelement des neuen Elements
     */
    public Element (Vergleichbar wert, Element next) {
	this.wert = wert;
	this.next = next;
    }
    
    /** @return Wert des Elements
     */
    public Vergleichbar getWert () {
	return wert;
    }
    
    /** @param wert Wert, den das Element erhalten soll
     */	
    public void setWert (Vergleichbar wert) {
	this.wert = wert;
    }
    /** @return Nachfolger des Elements
     */
    public Element getNext () {
	return next;
    }
    
    /** @param next Nachfolger, den das Element erhalten soll
     */	
    public void setNext (Element next) {
	this.next = next;
    }
    
    public String toString () {
	return wert.toString();
    }


    /** vergleicht zwei Elemente inhaltlich nach ihrem Wert
     *  @param zuvergleichen das Element, mit dem 
     *         das aktuelle Element verglichen werden soll
     *  @return true, falls die Werte der beiden Elemente 
     *          inhaltlich gleich sind und sonst false
     */
    public boolean gleich (Element zuvergleichen) {
	
	return wert.gleich (zuvergleichen.wert);

    }
    
}




