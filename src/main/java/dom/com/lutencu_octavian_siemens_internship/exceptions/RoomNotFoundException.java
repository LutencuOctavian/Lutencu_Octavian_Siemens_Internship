package dom.com.lutencu_octavian_siemens_internship.exceptions;

public class RoomNotFoundException extends RuntimeException{
    public RoomNotFoundException() {
    }

    public RoomNotFoundException(String message) {
        super(message);
    }

    public RoomNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoomNotFoundException(Throwable cause) {
        super(cause);
    }

    public RoomNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
