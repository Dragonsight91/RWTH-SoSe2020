public class Rechnung3 {
  
  public static void main (String [] arguments) {

      int y = -1 + 23 * 33 + 3 * 7 * (5 + 6);     
     
      /*  Verwende (von uns) vordefinierte Klasse Simple IO
          zur Eingabe von Werten
       */ 

      int x = SimpleIO.getInt("Gib eine Zahl ein");

      // Jetzt hat x den eingegebenen Wert.
   
      System.out.print ("Das Resultat ist ");
      System.out.println (x + y);
      
  }

}



