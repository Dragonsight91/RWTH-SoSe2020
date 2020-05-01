public class Call_by_value {

    public static void f (double r) {
        r = 4.6;
    }

    public static void main (String [] args) {
        double s = 2.1;
        
        System.out.println("s: " + s);
    
        f(s);
    
        System.out.println("s: " + s);
    }
}
