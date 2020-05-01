public class Rechteck_Programm {
    
    public static void main (String [] args) {
	
    	Rechteck r = new Rechteck ();
    	Rechteck s = new Rechteck (1,2);
    	Rechteck t = new Rechteck (3.0);
    	Rechteck u = new Rechteck (3);
    	Rechteck v = new Rechteck (1,2,3);
    
    	System.out.println ("Rechteck r: " + r);
    	System.out.println ("Rechteck s: " + s);
    	System.out.println ("Rechteck t: " + t);
    	System.out.println ("Rechteck u: " + u);
    	System.out.println ("Rechteck v: " + v);
    	
    
    	Rechteck w = new Rechteck (u);
    	System.out.println ("Rechteck w: " + w);
    	
	
    }
    
}
