public class Subtract {

  public static void main (String [] args) {
       
     int x = SimpleIO.getInt("Gib erste Zahl ein"), 
     	 y = SimpleIO.getInt("Gib zweite Zahl ein"),
	 z, res;

     //Vorbedingung: x >= y

     z = y;
     res = 0;

     //Invariante: x >= z & res = z - y
     //Variante: x - z

     while (x > z) {
         z = z + 1;
         res = res + 1;
     }

     //Nachbedingung: res = x - y

     SimpleIO.output(x + " - " + y + " = " + res, "Ergebnis");
 
  }

}

