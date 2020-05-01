public class Maximum {
  
  public static void main (String [] arguments) {
      
      int x = SimpleIO.getInt("Bitte erste Zahl eingeben");
      int y = SimpleIO.getInt("Bitte zweite Zahl eingeben");

      int maximum = Math.max(x,y);

      System.out.print ("Das Maximum ist ");
      System.out.println (maximum); 	

  }

}
