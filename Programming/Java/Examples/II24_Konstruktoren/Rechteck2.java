public class Rechteck2 {

    //Objektattribute
    double laenge, breite;
    int strichstaerke;
    
    //Konstruktor 1
    public Rechteck2 () {
    	laenge = breite = 1.0;
    	strichstaerke = 1;
    }
    
    //Konstruktor 2
    public Rechteck2 (double laenge, double breite) {
    	this.laenge = laenge;  
    	this.breite = breite;         
    	strichstaerke = 1;
    }
    
    //Konstruktor 3
    public Rechteck2 (double laenge) {
    	this.laenge = breite = laenge;  
    	strichstaerke = 1;
    }
    
    //Konstruktor 4
    public Rechteck2 (int strichstaerke) {
    	laenge = breite = 1.0;           
    	this.strichstaerke = strichstaerke;
    }
    
    //Konstruktor 5
    public Rechteck2 (int ... a) {
        laenge = a[0];
        breite = a[1];
        strichstaerke = 5;
    }
    
    //Objektmethode
    public String toString () {
    	return  "Laenge: " + laenge +
    		", Breite: " + breite +
    		", Strichstaerke: " + strichstaerke;
    }
    
}
