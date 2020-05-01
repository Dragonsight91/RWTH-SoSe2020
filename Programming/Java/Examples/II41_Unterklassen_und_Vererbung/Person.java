public class Person {

    /** Schluessel, der die Person eindeutig kennzeichnet
     */
    protected int key;

    protected String vorname, nachname;

    /** Gibt das Geschlecht der Person an
     */
    protected Gender gender;

    /** Gibt an, ob die Person einen Hochschulabschluss besitzt
     */
    protected boolean hochschule;

   

    public Person () {
        
        key = SimpleIO.getInt("Key der Person");
        vorname = SimpleIO.getString("Vorname der Person");
        nachname = SimpleIO.getString("Nachname der Person");
	if (SimpleIO.getBoolean("Ist die Person männlich?"))
	    {gender = Gender.m;}
	else if (SimpleIO.getBoolean("Ist die Person weiblich?"))
	    {gender = Gender.f;}
	else {gender = Gender.d;}
        hochschule = SimpleIO.getBoolean("Besitzt die Person einen Hochschulabschluss?"); 
    
    }
    
    public Person (int key) {   
        this.key = key;
    }
    
    public Person (String vorname, String nachname) {   
        this (0, vorname, nachname, Gender.m, false);
    }
    
    
    public Person (int key, String vorname, String nachname,
           Gender gender, boolean hochschule) {  
        
        this(key);
        this.vorname = vorname;
        this.nachname = nachname;
        this.gender = gender;
        this.hochschule = hochschule;
    }
    
    public String toString () {
        
        String anrede = "";

	if (gender == Gender.m) anrede = "Herr ";
	else if (gender == Gender.f) anrede = "Frau ";

	return anrede + vorname + " " + nachname;
    
    }
    
    public void mahnung (int gebuehr) {
        
        SimpleIO.output("Mitteilung an " + this +": \n" +
                        "Ihre Mahngebühr beträgt " + gebuehr + " Euro.","Mahnung");
    
    }
    
    
    
    public int mahnung (int gebuehr, int gebuehr2) {
        return gebuehr + gebuehr2;
    }


    public static void sendeMahnungen (Person [] ausleiher, int gebuehr) {
        
        for (Person p : ausleiher) {
            p.mahnung (gebuehr);
        }
     
    }
     
        
    public static void main (String [] args) {
        
        Person x = new Person ();
        
        SimpleIO.output("Eingelesen wurde " + x,"Test");
        
        Person y = new Person ("Hans", "Meier");
        
        SimpleIO.output("Eingelesen wurde " + y + " mit Schluessel " + y.key,"Test");
    
    }
    
    
}


    
