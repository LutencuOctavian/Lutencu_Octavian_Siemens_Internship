package dom.com.lutencu_octavian_siemens_internship.repositories;

import dom.com.lutencu_octavian_siemens_internship.dto.CommentDTO;
import dom.com.lutencu_octavian_siemens_internship.enteties.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    @Query("select new dom.com.lutencu_octavian_siemens_internship.dto.CommentDTO(comment.id, comment.comment, comment.userEntity.id, comment.hotelEntity.id) " +
            "from CommentEntity comment " +
            "where comment.userEntity.id = :userId ")
    List<CommentDTO> findAllCommentsForUser(@Param("userId") Long userId);

    @Query("select new dom.com.lutencu_octavian_siemens_internship.dto.CommentDTO(comment.id, comment.comment, comment.userEntity.id, comment.hotelEntity.id) " +
            "from CommentEntity comment "  +
            "where comment.hotelEntity.id = :hotelId ")
    List<CommentDTO> findAllCommentsForHotel(@Param("hotelId") Long hotelId);

    @Query("select new dom.com.lutencu_octavian_siemens_internship.dto.CommentDTO(comment.id, comment.comment, comment.userEntity.id, comment.hotelEntity.id) " +
            "from CommentEntity comment "  +
            "where comment.hotelEntity.id = :hotelId and comment.userEntity.id = :userId ")
    List<CommentDTO> findAllCommentsGivenByUserToHotel(@Param("userId") Long userId, @Param("hotelId") Long hotelId);
}
