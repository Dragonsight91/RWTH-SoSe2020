public class Rechteck2_Programm {

  public static void main (String [] arguments) {

    double flaeche;
    Rechteck2 r = new Rechteck2 (), 
              s = new Rechteck2 ();
    
    System.out.println ("Flaechenberechnung: " + Rechteck2.getFlaechenberechnung());
             
    r.setBreite (2.0); 
    r.setLaenge (2.5); 
    r.setStrichstaerke (1);

    System.out.println(r);

    flaeche = r.flaeche ();   

    System.out.println ("Flaechenberechnung: " +  Rechteck2.getFlaechenberechnung());
    
    s.setBreite (1.5);
    s.setLaenge (2.1);
    s.setStrichstaerke (3);
           
    System.out.println(s);
  
    flaeche = s.flaeche ();   

    System.out.println ("Flaechenberechnung: " + Rechteck2.getFlaechenberechnung());
    
    r.setLaenge (s.getLaenge() + 2);

    System.out.println(r);

  }
  
}
