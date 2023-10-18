package universitymanagement.exceptions;

public class NoSubjectsException extends Exception {
    public NoSubjectsException() {
    }

    public NoSubjectsException(String message) {
        super(message);
    }

    public NoSubjectsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSubjectsException(Throwable cause) {
        super(cause);
    }
}