public class Rechteck_Programm2 {

  public static void main (String [] arguments) {

    Rechteck r = new Rechteck (), 
             s = new Rechteck (), 
             t = new Rechteck ();
             
    r.laenge = 2.5;
    r.breite = 2.0;
    r.strichstaerke = 1;
    
    s.laenge = 2.1;
    s.breite = 1.5;
    s.strichstaerke = 3;
             
    System.out.println ("Laenge von r: " + r.laenge);
    System.out.println ("Breite von r: " + r.breite);
    System.out.println ("Strichstaerke von r: " + r.strichstaerke);
             
    System.out.println ("Laenge von s: " + s.laenge);
    System.out.println ("Breite von s: " + s.breite);
    System.out.println ("Strichstaerke von s: " + s.strichstaerke);
   
    r = s;

    System.out.println ("Laenge von r: " + r.laenge);
    System.out.println ("Breite von r: " + r.breite);
    System.out.println ("Strichstaerke von r: " + r.strichstaerke);

    r.laenge = 4.6;
          
    System.out.println ("Laenge von s: " + s.laenge);
    System.out.println ("Breite von s: " + s.breite);
    System.out.println ("Strichstaerke von s: " + s.strichstaerke);
   
    double flaeche = r.flaeche ();   
    
    System.out.println ("Flaeche von r: " + flaeche);
      
  }
  
}
