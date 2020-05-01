public class Even_Odd {

    public static boolean even (int x) {
    
        if      (x == 0) return true;
        else if (x > 0)  return odd (x - 1);
        else             return odd (x + 1);
        
    }

    public static boolean odd (int x) {
        
        if      (x == 0) return false;
        else if (x > 0)  return even (x - 1);
        else             return even (x + 1);
        
    }

    
    public static void main (String [] args) {
            
        int x = SimpleIO.getInt("Bitte geben Sie eine Zahl ein: ");
        SimpleIO.output(x + " ist gerade: "   + even(x) + "\n" +
                        x + " ist ungerade: " + odd(x),"Ergebnis");
            
    }

}
