public class Fak {

 public static void main (String [] arguments) {
        
     int n = SimpleIO.getInt("Gib Zahl ein"), i, res;

     // <true>
     // <n = n>

     i = n;

     // <i = n>
     // <i = n & 1 = 1>

     res = 1;

     // <i! * res = n!>
     
     // Invariante: i! * res = n!
     // Variante:   i
     while (i > 1) {
     
         // <i! * res = n! & i > 1>
         // <(i-1)! * (res * i) = n!>

        res = res * i;

        // <(i-1)! * res = n!>

        i = i - 1; 
     
        // <i! * res = n!>

     }

     // <i! * res = n! & i <= 1>
     // <res = n!>

     SimpleIO.output("Fakultaet ist " + res, "Ergebnis");    
     
 }

}

