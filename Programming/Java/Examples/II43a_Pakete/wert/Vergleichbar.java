package wert;

/** Interface fuer Datentypen, deren Objekte auf 
 *  <em>inhaltliche</em>  Gleichheit verglichen werden können.
 *  @author Juergen Giesl
 */
public interface Vergleichbar {
    
    /** vergleicht zwei Objekte inhaltlich
     *  @param zuvergleichen das Objekt, mit dem 
     *         das aktuelle Objekt verglichen werden soll
     *  @return true, falls die Objekte inhaltlich gleich sind und sonst false
     */
    boolean gleich (Vergleichbar zuvergleichen);

}


