public class Betrag {
  
  public static void main (String [] arguments) {

	int x = SimpleIO.getInt("Bitte eine Zahl eingeben");
       	
	int betrag;
	betrag = x >= 0 ? x : -x;
	
	SimpleIO.output("Betrag ist " + betrag, "Ergebnis"); 
	   
  }

}
