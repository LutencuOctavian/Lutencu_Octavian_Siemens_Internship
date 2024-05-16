package dom.com.lutencu_octavian_siemens_internship.services.hotel_service;

import dom.com.lutencu_octavian_siemens_internship.services.IGenericCRUDOperations;

import java.util.List;

public interface IHotelService<K, T> extends IGenericCRUDOperations<T> {
    List<T> searchHotelsInRange(K k);
}
