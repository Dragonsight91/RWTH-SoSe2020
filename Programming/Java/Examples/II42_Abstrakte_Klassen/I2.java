public interface I2 extends H2 {

    default int u () {
    	return 0;
    }

    int v ();

    static int w () {
    	return 4;
    }

}
