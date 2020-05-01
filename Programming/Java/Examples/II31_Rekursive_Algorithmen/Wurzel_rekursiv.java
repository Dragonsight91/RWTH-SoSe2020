public class Wurzel_rekursiv {
    
    public static float sqrt (float uG, float oG, float x) {
        
        float m, 
              epsilon = 1e-3f;
        
        m = (uG + oG) / 2;      
        if  (oG - uG <= epsilon)    return m;
        else if (m * m > x)         return sqrt (uG, m, x);
        else                        return sqrt (m, oG, x);
        
    }
    
    public static void main (String [] args) {
    
        int x = SimpleIO.getInt("Bitte geben Sie eine Zahl ein: ");
        SimpleIO.output("Wurzel von " + x + " ist " + sqrt(0,x,x),"Ergebnis");
            
    }
    
}
