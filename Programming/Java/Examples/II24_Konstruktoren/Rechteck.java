public class Rechteck {

    //Objektattribute
    double laenge, breite;
    int strichstaerke;
    
    //Konstruktor 1
    public Rechteck () {
    	laenge = breite = 1.0;
    	strichstaerke = 1;
    }

    //Konstruktor 2
    public Rechteck (double l, double b) {
    	laenge = l;
    	breite = b;
    	strichstaerke = 1;
    }
    
    //Konstruktor 3
    public Rechteck (double kantenlaenge) {
    	laenge = breite = kantenlaenge;
    	strichstaerke = 1;
    }
    
    //Konstruktor 4
    public Rechteck (int s) {
    	laenge = breite = 1.0;
    	strichstaerke = s;
    } 

    //Konstruktor 5
    public Rechteck (int... a) {
    	laenge = a[0]; breite = a[1]; strichstaerke = 5;
    }
    
    //Kopier-Konstruktor
    public Rechteck (Rechteck original) {
    	
    	if    (original != null) {
    	    laenge = original.laenge;
    	    breite = original.breite;
    	    strichstaerke = original.strichstaerke;
    	}
    	else  { // kein Original vorhanden
    	    laenge = breite = 1.0;
    	    strichstaerke = 1;
    	}
    	
    }
    

    //Objektmethode
    public String toString () {
    	return  "Laenge: " + laenge +
    		", Breite: " + breite +
    		", Strichstaerke: " + strichstaerke;
    }

}
