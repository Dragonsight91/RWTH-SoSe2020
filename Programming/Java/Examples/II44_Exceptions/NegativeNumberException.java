public class NegativeNumberException extends Exception {

    private int value;
    
    public NegativeNumberException(int value) {
    	this.value = value;
    }
    
    public int getValue() {
    	return value;

    }
}