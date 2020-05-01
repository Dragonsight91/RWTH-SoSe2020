public class Bruch_Test {

    public static void main (String [] args) {

    	
    	Zahl a = new Bruch ();
    	System.out.println ("Zahl a: " + a);
    
    	Bruch b = new Bruch ();
    	System.out.println ("Bruch b: " + b);
    	
    	System.out.println ("a.gleich(b): " + a.gleich(b));
    
    	Vergleichbar c = new Bruch (2,4);
    	System.out.println ("Vergleichbar c: " + c);
    	
    	Zahl d = new Bruch (3,0);
    	System.out.println ("Zahl d: " + d);
    	
    	System.out.println ("c.gleich(d): " + c.gleich(d));
    
    	Vergleichbar e = new Wort ("hallo");
    	Vergleichbar f = new Wort ("HallO");
    
    	System.out.println ("e.gleich(f): " + e.gleich(f));
    
    	System.out.println ("e.gleich(a): " + e.gleich(a));
    
    	System.out.println ("a.gleich(e): " + a.gleich(e));
    
    
    	
    
    }

}

	
	
