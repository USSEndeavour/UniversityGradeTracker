package universitymanagement.exceptions;

public class NoFacultiesException extends Exception {
    public NoFacultiesException() {
    }

    public NoFacultiesException(String message){
        super(message);
    }

    public NoFacultiesException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoFacultiesException(Throwable cause) {
        super(cause);
    }
}