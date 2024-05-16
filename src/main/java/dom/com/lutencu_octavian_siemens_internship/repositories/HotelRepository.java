package dom.com.lutencu_octavian_siemens_internship.repositories;

import dom.com.lutencu_octavian_siemens_internship.dto.HotelDTO;
import dom.com.lutencu_octavian_siemens_internship.dto.RoomDTO;
import dom.com.lutencu_octavian_siemens_internship.enteties.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
    @Query("select new dom.com.lutencu_octavian_siemens_internship.dto.HotelDTO(hotel.id, hotel.name, hotel.latitude, hotel.longitude) " +
            "from HotelEntity hotel " +
            "where hotel.latitude >= :minLat and hotel.latitude<= :maxLat and " +
            "hotel.longitude>= :minLong and hotel.longitude<= :maxLong")
    Optional<List<HotelDTO>> findAllHotelsThaAreInRange(@Param("minLat") double minLat,
                                                        @Param("maxLat") double maxLat,
                                                        @Param("minLong") double minLong,
                                                        @Param("maxLong") double maxLong);

    @Query("select new dom.com.lutencu_octavian_siemens_internship.dto.RoomDTO(room.id, room.roomNumber, room.roomType, room.price, room.isAvailable) " +
            "from HotelEntity hotel " +
            " inner join RoomEntity room on room.hotelEntity.id = hotel.id " +
            "where room.isAvailable = true and hotel.id = :hotelId")
    Optional<List<RoomDTO>> findAllAvailableRoomsForHotelById(@Param("hotelId") Long hotelId);
}
