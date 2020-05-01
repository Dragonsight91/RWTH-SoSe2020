public class Stud_ohne_Vererbung {

    /** Schluessel, der den Studenten bzw. die Studentin eindeutig kennzeichnet
     */
    private int key;

    private String vorname, nachname;

    private int matrikelnr;

    /** Gibt das Geschlecht des Studenten bzw. der Studentin an
     */
    private Gender gender;

   
    public Stud_ohne_Vererbung () {
    	    	    
    	key = SimpleIO.getInt("Key der Person");
    	vorname = SimpleIO.getString("Vorname der Person");
    	nachname = SimpleIO.getString("Nachname der Person");
    	if (SimpleIO.getBoolean("Ist die Person männlich?"))
	     {gender = Gender.m;}
	else if (SimpleIO.getBoolean("Ist die Person weiblich?"))
	     {gender = Gender.f;}
	else {gender = Gender.d;}
        
    }

	
    public String toString () {
        
        String anrede = "";

	if (gender == Gender.m) anrede = "Herr ";
	else if (gender == Gender.f) anrede = "Frau ";

	return anrede + vorname + " " + nachname;
    
    }


    public static void main (String [] args) {
    
    	Stud_ohne_Vererbung x = new Stud_ohne_Vererbung ();
    
    	SimpleIO.output ("Eingelesen wurde " + x,"Test");

    }

}
	

    
