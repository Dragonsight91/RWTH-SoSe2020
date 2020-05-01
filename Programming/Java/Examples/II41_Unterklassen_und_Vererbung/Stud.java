public class Stud extends Person {
    
    protected int matrikelnr;
    
    /** Hochschule, an der der Student bzw. die Studentin immatrikuliert ist
     */
    protected String hochschule;
    
    public Stud  () {
        
        matrikelnr = SimpleIO.getInt("Matrikelnummer des Studenten bzw. der Studentin");
        hochschule = SimpleIO.getString("Hochschule des Studenten bzw. der Studentin");
    
    }
    
    
    public Stud  (int key, String vorname, String nachname, 
                 Gender g, int matrikelnr, String hochschule) {
        
        super (key, vorname, nachname, g, true);
            
        this.matrikelnr = matrikelnr; 
        this.hochschule = hochschule;
    
    }
    
    
    public void mahnung (int mahngebuehr) {
        
        /*
            SimpleIO.output("Mitteilung an " + this +": \n 
                             Ihre Mahngebuehr betraegt " + gebuehr + " Euro.","Mahnung");
        */
        super.mahnung (mahngebuehr);    
        
        SimpleIO.output("Mitteilung an das Studierendensekretariat: \n" + 
                        this + " kann sich noch nicht exmatrikulieren," +
                        "es stehen noch Mahngebühren aus.","Mahnung");
    
    }
    
    
    
    public boolean hatHochschulabschluss () {
    
        return super.hochschule;
    
    }
    
        
    
    public static void main (String [] args) {
    
        
        Stud x = new Stud ();
        
        SimpleIO.output("Eingelesen wurde " + x + " mit Matrikelnr. " + x.matrikelnr,"Test");
        
        SimpleIO.output(x + " hat schon Hochschulabschluss: " + x.hatHochschulabschluss(),"Test");
        
        Stud y = new Stud (123, "Hugo", "Meier", Gender.m, 54321, "RWTH");
        
        SimpleIO.output("Eingelesen wurde " + y + " mit Schluessel " + y.key
                    + ", Student/Studentin an der " + y.hochschule,"Test");
        
       
    }
    
}


    

