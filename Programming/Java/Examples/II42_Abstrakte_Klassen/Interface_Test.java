public class Interface_Test {

    public static void main (String [] args) {
    
    	I i;
    	J j;
    	C z = new C ();
    
    	i = z;
    	j = z;
    
    	// nicht erlaubt:
    	// j = i;
    
    	j = (C) i;
    	z = (C) i;
    
    	i.b (5);
    	j.b (5);
    
    	i.q (2);
    	j.q (2);
    
    	System.out.println("I.x = " + I.x);
    	System.out.println("J.x = " + J.x);
    
    	//nicht definiert:
    	//System.out.println("C.x = " + C.x);
    
    	System.out.println("C.y = " + C.y);

    }

}
	
	


	
