public class Parameteruebergabe {

    public static void f (Rechteck r) {
        r = new Rechteck ();

    	r.laenge = 2.5;
    	r.breite = 2.0;
    	r.strichstaerke = 1;

    }

    public static void main (String [] args) {
    	Rechteck s = new Rechteck ();
    	s.laenge = 2.1;
    	s.breite = 1.5;
    	s.strichstaerke = 3;
    	
    	System.out.println ("Laenge von s: " + s.laenge);
    	System.out.println ("Breite von s: " + s.breite);
    	System.out.println ("Strichstaerke von s: " + s.strichstaerke);
    
    	f(s);
    
    	System.out.println ("Laenge von s: " + s.laenge);
    	System.out.println ("Breite von s: " + s.breite);
    	System.out.println ("Strichstaerke von s: " + s.strichstaerke);
    }
}
