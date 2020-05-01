public class Rechteck2 {
  
    // Klassenattribut
    private static int flaechenberechnung = 0;
    
    
    //Objektattribute
    private double flaeche, breite;
    private int strichstaerke;
    
    
    //Selektoren
    public void setLaenge (double l) {
        flaeche = l * breite;
    }
    
    public double getLaenge () {
        return flaeche / breite;
    }

   
    public void setBreite (double b) {
        breite = b;
    }
    
    public double getBreite () {
        return breite;
    }

    public void setStrichstaerke (int s) {
        strichstaerke = s;
    }
    
    public double getStrichstaerke () {
        return strichstaerke;
    }

    public static int getFlaechenberechnung () {
        return flaechenberechnung;
    }

    public double flaeche () {
        flaechenberechnung++;
        return flaeche;
    }

    
    public String toString () { 
        return ("Laenge: " + getLaenge() + 
                ", Breite: " + breite + 
                ", Strichstaerke: " + strichstaerke); 
    }
 

}
