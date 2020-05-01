public class Fak_assert {

 public static void main (String [] arguments) {
       
     int n = SimpleIO.getInt("Gib Zahl ein"), i, res;

     assert true;
     assert n == n;

     i = n;

     assert i == n;
     assert i == n && 1 == 1;

     res = 1;

     assert fac(i) * res == fac(n);   
     
     while (i > 1) {
     
         assert fac(i) * res == fac(n) && i > 1;
         assert fac(i-1) * (res * i) == fac(n);

         res = res * i;

         assert fac(i-1) * res == fac(n);

         i = i - 1; 
     
         assert fac(i) * res == fac(n);

     }

     assert fac(i) * res == fac(n) && !(i > 1);   
     assert res == fac(n);

     SimpleIO.output("Fakultaet ist " + res, "Ergebnis");    
     
 }

 public static int fac (int n) {

     if (n > 1) return n * fac(n-1);
     else       return 1;
 
 }   


}

