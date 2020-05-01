public class C implements I, J {

    

    public void a () {
    	System.out.println ("Realisierung von a () in Klasse C.");
    }

    public void c () {
    	System.out.println ("Realisierung von c () in Klasse C.");
    }

    public void b (int i) {
    	System.out.println ("Realisierung von b (int i) in Klasse C" +
    			    " mit int-Parameter " + i);
    }
       
    public void b (double d) {
    	System.out.println ("Realisierung von b (double d) in Klasse C" +
    			    " mit double-Parameter " + d);
    }

    public void q (int n) {
    	System.out.println ("Realisierung von q (int n) in Klasse C" +
    			    " mit int-Parameter " + n);
    }
}
