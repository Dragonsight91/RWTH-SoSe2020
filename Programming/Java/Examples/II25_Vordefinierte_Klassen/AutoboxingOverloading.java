public class AutoboxingOverloading {
  
    public static int f (int i) {
        return 1;
    }
   
    public static int f (Integer x) {
        return 2;
    }
  
    public static int f (double d) {
        return 3;
    }
   
    public static int f (int... a) {
        return 4;
    }
   
    public static int f (Integer... a) {
        return 5;
    }
    
     

    public static void main (String [] args) {
        
       System.out.println(f(1));
       System.out.println(f(Integer.valueOf(1)));
        
    }
    
}
