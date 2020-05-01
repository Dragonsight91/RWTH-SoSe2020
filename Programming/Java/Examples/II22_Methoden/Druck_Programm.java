public class Druck_Programm {

    /** Druckprozedur.
     *  Gibt alle Werte in a aus.
     */
    public static void drucke (int[] a) {
        for (int x : a)
            System.out.print(x + " ");

        System.out.print("\n");
    }

    public static void main (String[] args) {
        int[] x = new int [4];
        x[0] = 5; x[1] = 2; x[2] = 7; x[3] = 4;              
        drucke (x);
    }

}
