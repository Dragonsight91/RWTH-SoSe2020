public class TooBigNumberException extends Exception {

    private int value;
    
    public TooBigNumberException(int value) {
    	this.value = value;
    }
    
    public String toString() {
    	return "Eingegebene Zahl " + value + " ist zu gross.";
    }
}