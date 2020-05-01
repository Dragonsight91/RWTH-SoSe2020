public class Person_Programm {

 
    public static void main (String [] args) {
    	
    	Stud s = new Stud ();
    	Angestellt a = new Angestellt ();
    	Person p = new Person (100, "Erna", "Huber", Gender.f, false) ;
    	int gebuehr;
    
    	p.mahnung(200);
    	
    	p = s;
    	
    	p.hochschule = true;
    	s.hochschule = "RWTH";
    	
    	SimpleIO.output("p.hochschule = " + p.hochschule + 
    			", s.hochschule = " + s.hochschule,"Test");
    	
    	gebuehr = p.mahnung(100, 50);
    	gebuehr = s.mahnung(100, 50);
    	
    	p.mahnung (gebuehr);
    	s.mahnung (gebuehr);
    	
    	s = (Stud) p;
    
    	if (p instanceof Stud) SimpleIO.output("p ist Student oder Studentin","Test");
    	if (p instanceof Angestellt) SimpleIO.output("p ist Angestellter oder Angestellte","Test");
    	if (p instanceof Person) SimpleIO.output("p ist Person","Test");
    	if (p instanceof Object) SimpleIO.output("p ist Object","Test");
    	
    	Person [] ausleiher = new Person [3];
    	ausleiher [0] = new Stud ();
    	ausleiher [1] = new Person ();
    	ausleiher [2] = new Angestellt ();
    	
    	Person.sendeMahnungen (ausleiher,25);
    	
	
    }

}
	
