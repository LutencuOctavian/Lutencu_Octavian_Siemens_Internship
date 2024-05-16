package dom.com.lutencu_octavian_siemens_internship.exceptions;

public class RoomOrHotelNotFoundException extends RuntimeException{
    public RoomOrHotelNotFoundException() {
    }

    public RoomOrHotelNotFoundException(String message) {
        super(message);
    }

    public RoomOrHotelNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoomOrHotelNotFoundException(Throwable cause) {
        super(cause);
    }

    public RoomOrHotelNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
