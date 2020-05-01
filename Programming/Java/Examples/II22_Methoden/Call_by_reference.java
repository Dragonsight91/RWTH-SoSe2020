public class Call_by_reference {

    public static void f (Rechteck r) {
        r.laenge = 4.6;
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
