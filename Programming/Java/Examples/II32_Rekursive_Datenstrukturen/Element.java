/** Datentyp für Elemente einer linearen Liste von ganzen Zahlen
 * @see Liste
 * @author Jürgen Giesl
 */
class Element {
    
    int wert;
    Element next; //Element ist eine rekursive Datenstruktur.
    
    /** Erzeugt ein neues Element ohne Nachfolger.
     *   @param wert Wert, den das neue Element erhalten soll
     */
    Element (int wert) {
        this.wert = wert;
        next = null;
    }
    
    /** Erzeugt ein neues Element mit Nachfolger.
     *   @param wert Wert, den das neue Element erhalten soll
     *   @param next Nachfolgerelement des neuen Elements
     */
    Element (int wert, Element next) {
        this.wert = wert;
        this.next = next;
    }
    
    /** @return Wert des Elements
     */
    int getWert () {
        return wert;
    }
    
    /** @param wert Wert, den das Element erhalten soll
     */ 
    void setWert (int wert) {
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
    
    public String toString () {
        return Integer.toString(wert);
    }
    
}
