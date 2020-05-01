public class Rechteck_Programm {
 
  public static void main (String [] arguments) {

    double [] laenge = new double [3];
    double [] breite = new double [3];
    int [] strichstaerke = new int [3];

    laenge[0] = 2.5;
    breite[0]= 2.0;
    strichstaerke[0] = 1;

    laenge[1] = 2.1;
    breite[1]= 1.5;
    strichstaerke[1] = 3;

    System.out.println ("Laenge des 0. Rechtecks: " + laenge[0]);
    System.out.println ("Breite des 0. Rechtecks: " + breite[0]);
    System.out.println ("Strichstaerke des 0. Rechtecks: " + strichstaerke[0]);
             
    System.out.println ("Laenge des 1. Rechtecks: " + laenge[1]);
    System.out.println ("Breite des 1. Rechtecks: " + breite[1]);
    System.out.println ("Strichstaerke des 1. Rechtecks: " + strichstaerke[1]);

    laenge [0] = laenge [1]; 
    breite [0] = breite [1];
    strichstaerke [0] = strichstaerke [1];

    System.out.println ("Laenge des 0. Rechtecks: " + laenge[0]);
    System.out.println ("Breite des 0. Rechtecks: " + breite[0]);
    System.out.println ("Strichstaerke des 0. Rechtecks: " + strichstaerke[0]);

    double flaeche = laenge [0] * breite [0];    

    System.out.println ("Flaeche des 0. Rechtecks: " + flaeche);
  
  }
  
}
