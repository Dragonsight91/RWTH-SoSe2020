public enum Tag {

	MO, DI, MI, DO, FR, SA, SO;

	public static boolean istWochenende (Tag t) {
	    return t == SA || t == SO;
	}
	
	public static void aktivitaet (Tag t) {
	    switch (t) {
    	    case SO:
    		System.out.println("ausruhen"); break;
    	    case SA:
    		System.out.println("Hausputz"); break;
    	    case DO: case FR:
    		System.out.println("aufraeumen"); break;
    	    default:
    		System.out.println("arbeiten"); break;
	    }
	}	
	
	public static void main (String [] args) {

	    Tag t = Tag.MO;

	    Tag s;
	    s = Tag.DI;
	    
	    System.out.println(valueOf("MO") == Tag.MO);

	    for (Tag d : Tag.values()) System.out.println(d);

	    System.out.println(Tag.DO.ordinal());

	    System.out.println(istWochenende(SO));

	    aktivitaet(SO);
	    aktivitaet(SA);
	    aktivitaet(FR);
	    aktivitaet(MO);

	}
}
	    
	    
	    
	    

