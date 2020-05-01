public class Angestellt extends Person {
    
    /** Gibt die Dienststellung des Angestellten bzw. der Angestellten an
     */
    protected String stellung;
    
    
    public Angestellt  () {
	
    	stellung = SimpleIO.getString("Stellung des/der Angestellten");
	
    }
    
    
    public void mahnung (int mahngebuehr) {
	
	
    	/*
    	  SimpleIO.output("Mitteilung an " + this +": \n 
                               Ihre Mahngebuehr betraegt " + gebuehr + " Euro.","Mahnung");
    
    	*/
    	super.mahnung (mahngebuehr);	
    	
    	SimpleIO.output("Mitteilung an die Gehaltsstelle: \n" +
                        "Bei dem Gehalt von " + this + 
    			        " müssen " + mahngebuehr + " Euro abgezogen werden.","Mahnung");
    }
    
    public static void main (String [] args) {
	
    	Angestellt x = new Angestellt ();
    	
    	SimpleIO.output("Eingelesen wurde " + x,"Test");
    	
    	x.mahnung(75);
	
    }
    
}


    

