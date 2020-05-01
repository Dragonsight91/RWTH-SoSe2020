public class Plus {

  public static void main (String [] args) {
     int a = SimpleIO.getInt("Gib erste Zahl ein"), 
     	 b = SimpleIO.getInt("Gib zweite Zahl ein"), x, res;


      //Vorbedingung: a >= 0

      x = a;
      res = b;

      //Invariante: x >= 0 & x + res = a + b
      //Variante: x 

      while (x > 0) {
          x = x - 1;
          res = res + 1;
      }

      //Nachbedingung: res = a + b

      SimpleIO.output(a + " + " + b + " = " + res, "Ergebnis");
 
  }

}

