public class InvalidLoginException extends Exception {

    public InvalidLoginException() {
        super("Incorrect username or password.\n");
    }

}