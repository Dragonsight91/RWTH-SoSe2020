public class Max {

 public static void main (String [] arguments) {

     int x = SimpleIO.getInt("Gib erste Zahl ein"), 
     	 y = SimpleIO.getInt("Gib zweite Zahl ein"),
	 res;

     // <true>
     // <y = y>

     res = y;

     // <res = y>

     if (x > y) 
        
        // <res = y & x > y>
        // <x = max(x,y)>
     
        res = x;

     // <res = max(x,y)>

     // sonst: <res = y & y >= x>
     //        <res = max(x,y)>

     SimpleIO.output("Maximum von " + x + " und " + y + " ist " + res, "Ergebnis");

 }

}

