package algorithms.exceptions;

public class ArrayIsFullException extends RuntimeException {
    public ArrayIsFullException() {
    }

    public ArrayIsFullException(String message) {
        super(message);
    }

    public ArrayIsFullException(String message, Throwable cause) {
        super(message, cause);
    }
}
