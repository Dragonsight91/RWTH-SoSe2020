public class C2 implements I2, J2 {

    public int u () {
    	return I2.super.u() + 1;
    }

    public int v () {
    	return 3;
    }

    public static void main (String[] args) {
    
    	C2 z = new C2 ();
    	System.out.println ("z.u() = " + z.u());
    	System.out.println ("z.v() = " + z.v());
    	System.out.println ("I2.w() = " + I2.w());
    
    }

}
