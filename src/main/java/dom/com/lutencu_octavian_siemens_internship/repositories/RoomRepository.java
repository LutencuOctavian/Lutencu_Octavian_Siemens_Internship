package dom.com.lutencu_octavian_siemens_internship.repositories;

import dom.com.lutencu_octavian_siemens_internship.enteties.HotelEntity;
import dom.com.lutencu_octavian_siemens_internship.enteties.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

    @Query("select room " +
            "from RoomEntity room " +
            "where room.id=:roomId")
    Optional<RoomEntity> findRoomById(@Param("roomId") Long roomId);

    @Query("select hotel " +
            "from RoomEntity room " +
            "inner join HotelEntity hotel on hotel.id = room.hotelEntity.id " +
            "where room.id = :roomId")
    Optional<HotelEntity> findHotelByRoomId(@Param("roomId") Long roomId);

    @Query("select room " +
            "from RoomEntity room " +
            "where room.isAvailable=false")
    Optional<List<RoomEntity>> getAllBookedRooms();
}
