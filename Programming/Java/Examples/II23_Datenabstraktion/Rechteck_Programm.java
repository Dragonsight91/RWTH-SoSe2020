public class Rechteck_Programm {

  public static void main (String [] arguments) {

    double flaeche;
    Rechteck r = new Rechteck (), 
             s = new Rechteck ();
    
    System.out.println ("Flaechenberechnung: " + Rechteck.getFlaechenberechnung());
             
    r.setBreite (2.0);
    r.setLaenge (2.5);
    r.setStrichstaerke (1);

    System.out.println(r);
    
    flaeche = r.flaeche ();   

    System.out.println ("Flaechenberechnung: " +  Rechteck.getFlaechenberechnung());
    
    s.setBreite (1.5);
    s.setLaenge (2.1);
    s.setStrichstaerke (3);

    System.out.println(s);
             
    flaeche = s.flaeche ();   

    System.out.println ("Flaechenberechnung: " + Rechteck.getFlaechenberechnung());
    
    r.setLaenge (s.getLaenge() + 2);

  }
  
}
