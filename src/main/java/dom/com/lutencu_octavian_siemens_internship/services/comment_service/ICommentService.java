package dom.com.lutencu_octavian_siemens_internship.services.comment_service;

import dom.com.lutencu_octavian_siemens_internship.services.IGenericCRUDOperations;

import java.util.List;

public interface ICommentService<T> extends IGenericCRUDOperations<T> {

    List<T> findAllCommentsForUser(Long userId);
    List<T> findAllCommentsForHotel(Long hotelId);
    List<T> findAllCommentsGivenByUserToHotel(Long userId, Long hotelId);
}
