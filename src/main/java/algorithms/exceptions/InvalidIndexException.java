package algorithms.exceptions;

public class InvalidIndexException extends RuntimeException {
    public InvalidIndexException() {
    }

    public InvalidIndexException(String message) {
        super(message);
    }

    public InvalidIndexException(String message, Throwable cause) {
        super(message, cause);
    }
}
