/** Datentyp Ordner zur Speicherung von Texten
 *  @author Juergen Giesl
 */
public class Ordner {     
    
    private static final int maxTexte = 20;    
    private String [] ordnerInhalt = new String [maxTexte];
    private int anzahlTexte = 0;    
    private String beschriftung = "";
    
    /** @return true, falls der Ordner voll ist, sonst false 
     */
    public boolean istVoll () {    
	return anzahlTexte == maxTexte;    
    }      
    
    
    /** @return true, falls der Ordner leer ist, sonst false 
     */
    public boolean istLeer () {    
	return anzahlTexte == 0;
    }
    
    /** @param t Text, der vorne im Ordner abgelegt wird 
     */   
    public void legeTextAb (String t) {    
	ordnerInhalt [anzahlTexte] = t;    
	anzahlTexte ++;                  
    }

    /** Liest zuletzt eingegebenen Text und loescht ihn. 
     *  @return letzten abgelegten Text 
     */
    public String entnehmeText () {    
	String t = ordnerInhalt [anzahlTexte-1];    
	ordnerInhalt [anzahlTexte-1] = "";    
	anzahlTexte --;    
	return t;                    
    } 

    /** @param t Beschriftung des Ordners */   
    public void beschrifte (String t) {   
	beschriftung = t;               
    } 

    /** @return Beschriftung des Ordners */   
    public String liesBeschriftung () {    
	return beschriftung;          
    } 
    
}
