public class Rechteck {
  
    // Klassenattribut
    static int flaechenberechnung = 0;
    
    
    //Objektattribute
    double laenge, breite;
    int strichstaerke;
    
    
    //Objektmethoden
    double flaeche () {
    	flaechenberechnung ++;
    	return laenge * breite;
    }

    
    public String toString () { 
    	return  "Laenge: " + laenge + 
    		    ", Breite: " + breite + 
    		    ", Strichstaerke: " + strichstaerke; 
    }
 

}
