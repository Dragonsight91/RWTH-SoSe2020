/** Generischer Datentyp fuer Elemente einer linearen Liste
 * @see Vergleichbar
 * @see Liste
 * @author Juergen Giesl
 */
public class Element <T extends Vergleichbar> {
    
        T wert;
        Element <T> next; //Element ist eine rekursive Datenstruktur.
    
    /** erzeugt ein neues Element ohne Nachfolger.
     *   @param wert Wert, den das neue Element erhalten soll
     */
    public Element (T wert) {
    	this.wert = wert;
    	next = null;
    }
    
    /** erzeugt ein neues Element mit Nachfolger.
     *   @param wert Wert, den das neue Element erhalten soll
     *   @param next Nachfolgerelement des neuen Elements
     */
    public Element (T wert, Element <T> next) {
    	this.wert = wert;
    	this.next = next;
    }
    
    /** @return Wert des Elements
     */
    public T getWert () {
    	return wert;
    }
    
    /** @param wert Wert, den das Element erhalten soll
     */	
    public void setWert (T wert) {
    	this.wert = wert;
    }
    /** @return Nachfolger des Elements
     */
    public Element <T> getNext () {
    	return next;
    }
    
    /** @param next Nachfolger, den das Element erhalten soll
     */	
    public void setNext (Element <T> next) {
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
    public boolean gleich (Element <T> zuvergleichen) {
	
    	return wert.gleich (zuvergleichen.wert);

    }
    


}




