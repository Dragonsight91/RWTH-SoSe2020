public class Rechteck3 {

    //Objektattribute
    double laenge, breite;
    int strichstaerke;
    
    //Konstruktor 1
    public Rechteck3 () {
	laenge = breite = 1.0;
	strichstaerke = 1;
    }
    
    //Konstruktor 2
    public Rechteck3 (double laenge, double breite) {
	this.laenge = laenge;  
	this.breite = breite;         
	strichstaerke = 1;
    }
    
    //Konstruktor 3
    public Rechteck3 (double laenge) {
	this.laenge = breite = laenge;  
	strichstaerke = 1;
    }
    
    //Konstruktor 4
    public Rechteck3 (int strichstaerke) {
	laenge = breite = 1.0;           
	this.strichstaerke = strichstaerke;
    }
    
    //Objektmethode
    public String toString () {
	return  "Laenge: " + laenge +
		", Breite: " + breite +
		", Strichstaerke: " + strichstaerke;
    }

    public Rechteck3 (Rechteck3 original) {
	this.laenge = original.laenge;
    }
    
    public static void main (String [] args) {

	Rechteck3 r = new Rechteck3();
	Rechteck3 s = new Rechteck3(r);

	System.out.println(s);

	s.laenge = 5;

	System.out.println(r);

    }
	

}
