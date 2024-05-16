package dom.com.lutencu_octavian_siemens_internship.services.room_service;

import dom.com.lutencu_octavian_siemens_internship.services.IGenericCRUDOperations;

import java.util.List;

public interface IRoomService<T> extends IGenericCRUDOperations<T> {

    boolean bookRoom(T t);
    boolean bookRoom(List<T> t);
    boolean cancelReservationRoom(Long roomId);
}
