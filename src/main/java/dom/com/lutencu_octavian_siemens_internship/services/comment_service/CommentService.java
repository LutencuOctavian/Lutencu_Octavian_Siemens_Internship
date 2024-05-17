package dom.com.lutencu_octavian_siemens_internship.services.comment_service;

import dom.com.lutencu_octavian_siemens_internship.dto.CommentDTO;
import dom.com.lutencu_octavian_siemens_internship.enteties.CommentEntity;
import dom.com.lutencu_octavian_siemens_internship.enteties.HotelEntity;
import dom.com.lutencu_octavian_siemens_internship.enteties.UserEntity;
import dom.com.lutencu_octavian_siemens_internship.exceptions.HotelNotFoundException;
import dom.com.lutencu_octavian_siemens_internship.exceptions.UserNotFoundException;
import dom.com.lutencu_octavian_siemens_internship.repositories.CommentRepository;
import dom.com.lutencu_octavian_siemens_internship.repositories.HotelRepository;
import dom.com.lutencu_octavian_siemens_internship.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService<CommentDTO> {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final HotelRepository hotelRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, UserRepository userRepository, HotelRepository hotelRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public CommentDTO create(CommentDTO commentDTO) {
        UserEntity userFromDB = userRepository.findById(commentDTO.getUserId()).orElseThrow(() -> new UserNotFoundException("user not found"));
        HotelEntity hotelFromBD = hotelRepository.findById(commentDTO.getHotelId()).orElseThrow(() -> new HotelNotFoundException("hotel not found"));
        CommentEntity commentEntity = CommentEntity.builder()
                                            .comment(commentDTO.getComment())
                                            .hotelEntity(hotelFromBD)
                                            .userEntity(userFromDB)
                                            .build();
        CommentEntity commentFromDB = commentRepository.save(commentEntity);

        return CommentDTO.builder()
                .id(commentFromDB.getId())
                .comment(commentFromDB.getComment())
                .userId(commentFromDB.getUserId())
                .hotelId(commentFromDB.getHotelId())
                .build();
    }

    @Override
    public CommentDTO update(CommentDTO commentDTO) {
        return null;
    }

    @Override
    public void delete(CommentDTO commentDTO) {

    }

    @Override
    public CommentDTO findById(long id) {
        return null;
    }

    @Override
    public List<CommentDTO> findAllCommentsForUser(Long userId) {
        return commentRepository.findAllCommentsForUser(userId);
    }

    @Override
    public List<CommentDTO> findAllCommentsForHotel(Long hotelId) {
        return commentRepository.findAllCommentsForHotel(hotelId);
    }

    @Override
    public List<CommentDTO> findAllCommentsGivenByUserToHotel(Long userId, Long hotelId) {
        return commentRepository.findAllCommentsGivenByUserToHotel(userId, hotelId);
    }
}
