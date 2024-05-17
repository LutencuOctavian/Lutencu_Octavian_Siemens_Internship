package dom.com.lutencu_octavian_siemens_internship.repositories;

import dom.com.lutencu_octavian_siemens_internship.enteties.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
