package universitymanagement.exceptions;

public class ExistingSubjectException extends Exception {
    public ExistingSubjectException() {
    }

    public ExistingSubjectException(String message){
        super(message);
    }

    public ExistingSubjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistingSubjectException(Throwable cause) {
        super(cause);
    }
}