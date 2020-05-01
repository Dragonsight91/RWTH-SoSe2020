public class Ordner_Test {


    public static void main (String [] args) {

    	Ordner o = new Ordner (); 
    	
    	o.beschrifte ("Kleine Gedichte"); 
    
    	if   (o.istVoll())        
    	     System.out.println("Ordner ist bereits voll");    
    	else o.legeTextAb ("Herr Ribeck auf Ribeck ...");   
    
    	if   (o.istVoll())        
    	     System.out.println("Ordner ist bereits voll");    
    	else o.legeTextAb ("Von drauss vom Walde komm ich her ..."); 
    
    	System.out.println (o.liesBeschriftung ());    
    	System.out.println ("------------------------------");  
    
    	if (!o.istLeer()) 
    	    System.out.println (o.entnehmeText ());        
    
    	if (!o.istLeer()) 
    	    System.out.println (o.entnehmeText ());        
        
        }   

}
        
