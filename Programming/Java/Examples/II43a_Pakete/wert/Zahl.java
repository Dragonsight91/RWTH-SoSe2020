package wert;


/** Abstrakte Klasse fuer Datentypen, die Zahlen repraesentieren.
 *  Insbesondere muessen solche Objekte ueber die Tastatur geaendert werden
 *  koennen und sie muessen inhaltlich miteinander verglichen werden koennen.
 *  @author Juergen Giesl
 */
public abstract class Zahl implements Aenderbar, Vergleichbar {
    

    /** rundet die aktuelle Zahl auf die naechstkleinere ganze Zahl ab.
     *  @return die abgerundete ganze Zahl
     */
    protected abstract int runde ();
    
    /** gibt Information ueber die naechstkleinere ganze Zahl aus.
     *  @return einen String "in etwa x", wobei x die  
     *          naechstkleinere ganze Zahl ist
     */
    public String rundungsinformation () {


        return "in etwa " + runde ();

    }

    

    

}
    
