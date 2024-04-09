package exception;

public class InvalidRepositoryException extends Exception {
    public InvalidRepositoryException(String message) {
        super(message);
    }

    public InvalidRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
