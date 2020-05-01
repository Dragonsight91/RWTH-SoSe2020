public class Len_Test {
	
	public static void main (String[] args) {
		
		Liste l = new Liste ();
				
		l.fuegeVorneEin (new Bruch(1,2));
		l.fuegeHintenEin (new Bruch(9,6));
		l.fuegeVorneEin (new Int(3));
		
		System.out.println("Die Laenge der Liste " + l +
				   " ist " + Liste.len(l));
		System.out.println("Danach ist die Liste " + l);
		
	}			
	
}

