public class InvalidAmountException extends Exception{
    
    public InvalidAmountException(String action) {
        super("Cannot " + action + " a negative amount.\n");
    }

}
