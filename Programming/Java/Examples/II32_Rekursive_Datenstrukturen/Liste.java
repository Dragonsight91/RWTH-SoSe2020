/** Datentyp fuer lineare Listen von ganzen Zahlen
 * @see Element
 * @author Juergen Giesl
 */
public class Liste {
    
    /** Attribut, das auf das erste Element der Liste zeigt
     */
    private Element kopf;
    
      
    /** Erzeugt eine neue leere Liste
     */
    public Liste () {
        kopf = null;
    }
    
    
    /** Sucht nach einem Element in der Liste.
     *   @param wert Der Wert des gesuchten Elements.
     *   @return Das erste Element in der Liste mit diesem Wert, falls
     *           es ein solches gibt. Sonst wird null zurueckgegeben.
     */
    public Element suche (int wert) {
        return suche (wert, kopf);
    }
    
    /** Sucht nach einem Element in einer vorgegebenen Liste.
     *   @param wert Der Wert des gesuchten Elements.
     *   @param kopf Der Kopf der Liste, in der gesucht wird.
     *   @return Das erste Element in jener Liste mit diesem Wert, falls
     *           es ein solches gibt. Sonst wird null zurueckgegeben.
     */
    private static Element suche (int wert, Element kopf) {
        if  (kopf == null)      return null;
        else if (kopf.wert == wert)     return kopf;
        else                return suche (wert, kopf.next);
    }
    
    /** Erzeugt einen String, der die Elemente der Liste von vorne nach hinten
     *   aufzaehlt.
     *   @return Die Liste als Zeichenkette
     */
    public String toString () {
        return  "( " + durchlaufe(kopf) + ")";
    }
    
    /** Gibt den Inhalt der Liste (von vorne nach hinten) auf dem Bildschirm aus.
     *   
     */
    public void drucke() {
        System.out.println (this);
    }
    
    
    /** Erzeugt einen String, der aus allen Elementen einer vorgegebenen Liste (von vorne
     *   nach hinten) besteht.
     *   @param kopf Der Kopf der zu durchlaufenden Liste.
     *   @return Die Zeichenkette aller Elemente jener Liste.
     */
    private static String durchlaufe (Element kopf) {
        if (kopf != null) return kopf.wert + " " + durchlaufe(kopf.next);
        else              return "";
    }
    
    /** Erzeugt einen String, der die Elemente der invertieren Liste 
     *   (d.h., von hinten nach vorne) aufzaehlt.
     *   @return Die invertierte Liste als Zeichenkette
     */
    public String toStringRueckwaerts () {
        return  "(" + durchlaufeRueckwaerts(kopf) + " )";
    }
    
    /** Gibt den Inhalt der invertierten Liste (d.h., von hinten nach 
     *   vorne) auf dem Bildschirm aus.
     *  
     */
    public void druckeRueckwaerts() {
        System.out.println (this.toStringRueckwaerts());
    }
    
    
    /** Erzeugt einen String, der aus allen Elementen einer 
     *   invertierten vorgegebenen Liste (von hinten
     *   nach vorne) besteht. 
     *   @param kopf Der Kopf der zu durchlaufenden Liste.
     *   @return Die Zeichenkette aller Elemente jener invertierten Liste.
     */
    private static String durchlaufeRueckwaerts (Element kopf) {
        if (kopf != null) return durchlaufeRueckwaerts(kopf.next) + " " + kopf.wert;
        else              return "";
    }
    
    
    /** Fuegt ein Element vorne in die Liste ein.
     *   @param wert Der Wert des einzufuegenden Elements.
     */
    public void fuegeVorneEin (int wert) {
        if  (kopf == null)  kopf = new Element (wert);
        else            kopf = new Element (wert, kopf);
    }
    
   
    /** Fuegt ein Element vor dem ersten groesseren Element in die Liste ein.
     *   War die Liste also vorher aufsteigend sortiert, so ist sie es hinterher
     *   immer noch.        // 
     *   @param wert Der Wert des einzufuegenden Elements.
     */
    public void fuegeSortiertEin (int wert) {
        kopf = fuegeSortiertEin (wert, kopf);
    }
    
    
    /** Fuegt ein Element vor dem ersten groesseren Element ein, das ab einem vorgegebenen
     *   Element in der Liste auftritt. Sind die Zahlen vor dem vorgegebenen Element 
     *   also kleiner als das einzufuegende Element und ist die Liste vorher aufsteigend
     *   sortiert, so ist sie es hinterher immer noch.
     *   @param wert Der Wert des einzufuegenden Elements.
     *   @param element Das Element der Liste, ab dem erst eingefuegt werden kann.
     *   @return Das erste Element der Teilliste ab dem vorgegebenen Element,
     *           wobei der einzufuegende Wert eingefuegt wurde.
     */
    private static Element fuegeSortiertEin (int wert, Element element) {
        if      (element == null)       return new Element (wert);  
        else if (wert < element.wert)   return new Element (wert, element);
        else                            {element.next = fuegeSortiertEin (wert, element.next);
                                        return element;}                                                
    }
    
    /** Fuegt ein Element vor dem ersten groesseren Element in die Liste ein.
     *   War die Liste also vorher aufsteigend sortiert, so ist sie es hinterher
     *   immer noch.
     *   @param wert Der Wert des einzufuegenden Elements.
    */
    public void fuegeSortiertEinIterativ (int wert) {
    
        Element element = kopf;
        
        if   (kopf == null || wert < kopf.wert) fuegeVorneEin(wert);
        else {
                 while  (element.next != null && wert >= element.next.wert)
                     element = element.next;
                            
                 element.next = new Element (wert, element.next);
        }
    
    }

    
    /** Loescht die komplette Liste.
     */
    public void loesche () {
        kopf = null;
    }
    
    /** Loescht das erste Element mit dem angegebenen Wert aus der Liste.
     *   @param wert Der Wert des zu loeschenden Elements.
     */
    public void loesche (int wert) {
        kopf = loesche (wert, kopf);
    }

    /** Loescht das erste Element mit dem angegebenen Wert, das ab einem vorgegebenen
     *   Element in der Liste auftritt.
     *   @param wert Der Wert des zu loeschenden Elements.
     *   @param element Das Element der Liste, ab dem erst geloescht werden kann.
     *   @return Das erste Element der Teilliste ab dem vorgegebenen Element,
     *           wobei der zu loeschende Wert geloescht wurde.
     */
    private static Element loesche (int wert, Element element) {
        if  (element == null)           return null;
        else if (wert == element.wert)  return element.next;
        else                            {element.next = loesche (wert, element.next);
                                        return element;}                                            
    }
            
            
}   
