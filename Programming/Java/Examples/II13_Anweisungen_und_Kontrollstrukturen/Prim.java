public class Prim {

    public static void main (String [] args) {
  
        int n = SimpleIO.getInt ("Gib eine Zahl ein"),
            wurzel = (int) Math.sqrt (n),
            teiler = 2; 
        boolean istPrimzahl = true;
    
        while (teiler <= wurzel && istPrimzahl)
        
            if (n % teiler == 0)  istPrimzahl = false;
            else                  teiler++;

        SimpleIO.output (n + " prim: " + istPrimzahl, "Ergebnis");
    }
}
