public class Wurzel {

    public static void main (String [] args) {
            
	float x = SimpleIO.getFloat ("Gib eine Zahl ein"),
              uG = 0,
              oG = x,
              m,
              epsilon = 1e-3f;
        do { 
            m = (uG + oG)/2;
            if (m*m > x)  oG = m;
            else          uG = m;
        }
        while (oG - uG > epsilon);

        SimpleIO.output ("Wurzel von " + x + " ist " + m, "Ergebnis");
    }

}
