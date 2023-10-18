package universitymanagement.exceptions;

public class InvalidSubjectException extends Exception {
    public InvalidSubjectException() {
    }

    public InvalidSubjectException(String message){
        super(message);
    }

    public InvalidSubjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSubjectException(Throwable cause) {
        super(cause);
    }
}