public class If2 {

    public static void main (String [] arguments) {
        
	int i = SimpleIO.getInt("Gib eine Zahl i ein");
	int j = SimpleIO.getInt("Gib eine Zahl j ein");

        if (i == 5) {
        
                if  (j == 5)
                System.out.println ("i und j sind 5.");
            }

        else System.out.println ("i ist nicht 5, " +
                                 "keine Aussage fuer j.");
    }

}

