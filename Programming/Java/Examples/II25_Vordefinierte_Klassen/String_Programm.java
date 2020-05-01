public class String_Programm {
    
    public static void main (String [] args) {
    	
    	String s = "Wort";
    	//String s = "Buchstabenfolge"; ist hier verboten
    	//String s = new String("Buchstabenfolge"); ist hier auch verboten
    	
    	String t = "Wort"; 
    	String u = new String("Wort");
    	// String u = new String("Worte"); ist hier verboten
    	
    	String v = new String("Wort");
    	
    	System.out.println ("s == t: " + (s == t));
    	
    	System.out.println ("s == u: " + (s == u));    
    	System.out.println ("s.equals(u): " + s.equals(u));
    
    	System.out.println ("u == v: " + (u == v));    
    	System.out.println ("u.equals(v): " + u.equals(v));
    	
    	
    	System.out.println ("Zeichen in " + u + 
    			    " an Index 2: " + u.charAt(2));
    	
    	System.out.println ("Laenge von " + u + ": " + u.length());
    	
    	System.out.println ("Zeichen in " + u + 
    			    " an Index 2: " + u.toCharArray() [2]);
	
    }
    
}
