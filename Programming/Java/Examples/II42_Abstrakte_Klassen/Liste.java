/** Datentyp fuer lineare Listen von vergleichbaren Objekten
 * @see Element
 * @see Vergleichbar
 * @author Juergen Giesl
 */
public class Liste {
    
    /** Attribut, das auf das erste Element der Liste zeigt
     */
    private Element kopf;
    
    /** erzeugt eine neue leere Liste
     */
    public Liste () {
    	kopf = null;
    }
    
    
    /** sucht nach einem Element in der Liste.
     *   @param wert Der Wert des gesuchten Elements.
     *   @return Das erste Element in der Liste mit diesem Wert, falls
     *           es ein solches gibt. Sonst wird null zurueckgegeben.
     */
    public Element suche (Vergleichbar wert) {
    	return suche (wert, kopf);
    }
    
    /** sucht nach einem Element in einer vorgegebenen Liste.
     *   @param wert Der Wert des gesuchten Elements.
     *   @param kopf Der Kopf der Liste, in der gesucht wird.
     *   @return Das erste Element in jener Liste mit diesem Wert, falls
     *           es ein solches gibt. Sonst wird null zurueckgegeben.
     */
    private static Element suche (Vergleichbar wert, Element kopf) {
    	if	(kopf == null) 		 return null;
    	else if (wert.gleich(kopf.wert)) return kopf;
    	else				 return suche (wert, kopf.next);
    }
    
    /** erzeugt einen String, der die Elemente der Liste von vorne nach hinten
     *   aufzaehlt.
     *   @return Die Liste als Zeichenkette
     */
    public String toString () {
    	return 	"( " + durchlaufe(kopf) + ")";
    }
    
    /** gibt den Inhalt der Liste (von vorne nach hinten) auf dem Bildschirm aus.
     */
    public void drucke() {
    	System.out.println (this);
    }
    
    
    /** erzeugt einen String, der aus allen Elementen einer vorgegebenen Liste (von vorne
     *   nach hinten) besteht.
     *   @param kopf Der Kopf der zu durchlaufenden Liste.
     *   @return Die Zeichenkette aller Elemente jener Liste.
     */
    private static String durchlaufe (Element kopf) {
    	if (kopf != null) return kopf.wert + " " + durchlaufe(kopf.next);
    	else              return "";
    }
    
    /** erzeugt einen String, der die Elemente der invertieren Liste 
     *   (d.h., von hinten nach vorne) aufzaehlt.
     *   @return Die invertierte Liste als Zeichenkette
     */
    public String toStringRueckwaerts () {
    	return 	"(" + durchlaufeRueckwaerts(kopf) + " )";
    }
    
    /** gibt den Inhalt der invertierten Liste (d.h., von hinten nach 
     *   vorne) auf dem Bildschirm aus.
     */
    public void druckeRueckwaerts() {
    	System.out.println (this.toStringRueckwaerts());
    }
    
    
    /** erzeugt einen String, der aus allen Elementen einer 
     *   invertierten vorgegebenen Liste (von hinten
     *   nach vorne) besteht. 
     *   @param kopf Der Kopf der zu durchlaufenden Liste.
     *   @return Die Zeichenkette aller Elemente jener invertierten Liste.
     */
    private static String durchlaufeRueckwaerts (Element kopf) {
    	if (kopf != null) return durchlaufeRueckwaerts(kopf.next) + " " + kopf.wert;
    	else	          return "";
    }
    
    
    /** fuegt ein Element vorne in die Liste ein.
     *   @param wert Der Wert des einzufuegenden Elements.
     */
    public void fuegeVorneEin (Vergleichbar wert) {
    	if 	(kopf == null)	kopf = new Element (wert);
    	else			kopf = new Element (wert, kopf);
    }
    

    /** loescht die komplette Liste.
     */
    public void loesche () {
    	kopf = null;
    }
	
    /** loescht das erste Element mit dem angegebenen Wert aus der Liste.
     *   @param wert Der Wert des zu loeschenden Elements.
     */
    public void loesche (Vergleichbar wert) {
    	kopf = loesche (wert, kopf);
    }

    /** loescht das erste Element mit dem angegebenen Wert, das ab einem vorgegebenen
     *   Element in der Liste auftritt.
     *   @param wert Der Wert des zu loeschenden Elements.
     *   @param element Das Element der Liste, ab dem erst geloescht werden kann.
     *   @return Das erste Element der Teilliste ab dem vorgegebenen Element,
     *           wobei der zu loeschende Wert geloescht wurde.
     */
    private static Element loesche (Vergleichbar wert, Element element) {
    	if 	(element == null) 	    return null;
    	else if (wert.gleich(element.wert)) return element.next;
    	else				    {element.next = loesche (wert, element.next);
    	                                    return element;}											
    }



			
}	

