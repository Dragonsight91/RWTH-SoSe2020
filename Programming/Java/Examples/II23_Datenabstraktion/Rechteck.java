public class Rechteck {
  
    // Klassenattribut
    private static int flaechenberechnung = 0;
    
    
    //Objektattribute
    private double laenge, breite;
    private int strichstaerke;
    
    //Selektoren
    public void setLaenge (double l) {
        laenge = l;
    }
    
    public double getLaenge () {
        return laenge;
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

    //Objektmethoden
    public double flaeche () {
        flaechenberechnung++;
        return laenge * breite;
    }

    
    public String toString () { 
        return ("Laenge: " + laenge + 
            ", Breite: " + breite + 
            ", Strichstaerke: " + strichstaerke); 
    }
    
       
    
}
