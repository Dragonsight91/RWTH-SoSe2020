public class Betrag {

  public static void main (String [] arguments) {

     int x = SimpleIO.getInt("Gib eine Zahl ein"), res;

     // <true>


     if (x < 0)

        // <x < 0>
        // <-x = |x|>

        res = -x;

         // <res = |x|>
     
     else

         // <x >= 0>
         // <x = |x|>
     
         res = x;
         

     // <res = |x|>

     // <res = |x|>

     SimpleIO.output("Betrag von " + x + " ist " + res, "Ergebnis");

 }

}

