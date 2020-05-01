public class Rechteck_Programm {

  public static void main (String [] arguments) {

    double flaeche;
    Rechteck r = new Rechteck (), 
             s = new Rechteck (); 
    
    System.out.println ("Flaechenberechnung: " + Rechteck.flaechenberechnung);
             
    r.laenge = 2.5;
    r.breite = 2.0;
    r.strichstaerke = 1;

    System.out.println(r);

    flaeche = r.flaeche ();   

    System.out.println ("Flaechenberechnung: " +  Rechteck.flaechenberechnung);
    
    s.laenge = 2.1;
    s.breite = 1.5;
    s.strichstaerke = 3;
             
    System.out.println(s);

    flaeche = s.flaeche ();   

    System.out.println ("Flaechenberechnung: " + Rechteck.flaechenberechnung);
    

  }
  
}
