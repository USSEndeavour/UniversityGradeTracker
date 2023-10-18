package universitymanagement.exceptions;

public class NoStudentsException extends Exception {
    public NoStudentsException() {
    }

    public NoStudentsException(String message) {
        super(message);
    }

    public NoStudentsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoStudentsException(Throwable cause) {
        super(cause);
    }
}