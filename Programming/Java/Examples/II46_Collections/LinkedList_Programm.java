import java.util.*;

public class LinkedList_Programm {

    public static void main (String [] args) {

    	LinkedList <String> sl = new LinkedList <> ();	
    
    	sl.addFirst("drei");
    	sl.addFirst("zwei");
    	sl.addFirst("eins");
    
    	Iterator <String> it = sl.iterator();
    	
    	while (it.hasNext()) {
    	    
    	    String s = it.next();
    	    System.out.println(s);
    
    	}
    
    
    	for (String s : sl) {
    	    
    	    System.out.println(s);
    
    	}
    
    	it = sl.iterator();
    	it.next();
    	it.remove();
    
    
    	for (String s : sl) {
    	    
    	    System.out.println(s);
    
    	}
    
    
    	LinkedList <Integer> il = new LinkedList <> ();
    
    	il.addFirst(3);
    	il.addFirst(2);
    	il.addFirst(1);
    
    	Iterator <Integer> iit = il.iterator();
    
    	while (iit.hasNext()) {    
    	    Integer i = iit.next();
    	    System.out.println(i);
    	}
    
    	iit = il.iterator();
        	
    	while (iit.hasNext()) {    
    	    int i = iit.next();
    	    System.out.println(i);
    	}
    
    	for (Integer i : il) {
    	    System.out.println(i);
    	    // il.addFirst(0); // compiliert, aber fuehrt zu Fehler bei Ausfuehrung
    	}
    
    	for (int i : il) {
    	    System.out.println(i);
    	    // il.addFirst(0); // compiliert, aber fuehrt zu Fehler bei Ausfuehrung
    	}
    	
    }

}