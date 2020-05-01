public class Switch {

    public static void main (String [] arguments) {
        
	int i = SimpleIO.getInt("Gib eine Zahl i ein");
	
        switch (i) {
            case 0: case 1: case 2: case 3: case 4: 
            System.out.println ("i kleiner 5."); break;
      
            case 5: 
            System.out.println ("i gleich 5."); break;
      
            default: 
            System.out.println ("i groesser 5.");
          }
    
    }

}
