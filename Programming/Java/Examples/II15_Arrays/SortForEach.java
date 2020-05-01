public class SortForEach {

    public static void main (String [] args) {

	int i,j,z;

	int n = SimpleIO.getInt("Wieviele Zahlen sortieren?");
	int [] a = new int[n];

	//Lies Elemente ein
	for (i = 0; i < n; i++) {
	    a[i] = SimpleIO.getInt("Gib eine Zahl ein");
	}
	

	//Sortiere Elemente
	for (i = 0; i < n-1; i++)
   
	    //Vertausche a[i] mit kleinstem Nachfolger
	    for (j = i+1; j < n; j++)

    		if (a[i] > a[j]) { //Nachfolger kleiner als a[i]?
    
    		    //Vertausche a[i] und a[j]
    		    z = a[i]; 
    		    a[i] = a[j]; 
    		    a[j] = z; 
    		}

	//Gib sortierte Elemente aus
	String result = "";
	for (int x : a) result = result + x + " ";
	
	SimpleIO.output(result,"Sortierte Elemente");

    }

}
