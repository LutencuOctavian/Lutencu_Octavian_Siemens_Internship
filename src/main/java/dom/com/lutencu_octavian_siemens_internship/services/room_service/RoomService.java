package dom.com.lutencu_octavian_siemens_internship.services.room_service;

import dom.com.lutencu_octavian_siemens_internship.dto.RoomDTO;
import dom.com.lutencu_octavian_siemens_internship.enteties.HotelEntity;
import dom.com.lutencu_octavian_siemens_internship.enteties.RoomEntity;
import dom.com.lutencu_octavian_siemens_internship.exceptions.HotelNotFoundException;
import dom.com.lutencu_octavian_siemens_internship.exceptions.RoomNotFoundException;
import dom.com.lutencu_octavian_siemens_internship.repositories.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements IRoomService<RoomDTO>{

    private final RoomRepository roomRepository;
    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public RoomDTO create(RoomDTO roomDTO) {
        return null;
    }

    @Override
    public RoomDTO update(RoomDTO roomDTO) {
        return null;
    }

    @Override
    public void delete(RoomDTO roomDTO) {

    }

    @Override
    public RoomDTO findById(long id) {
        return null;
    }

    @Override
    public boolean bookRoom(RoomDTO roomDTO) {
        Optional<RoomEntity> roomEntityFromDB = roomRepository.findRoomById(roomDTO.getId());
        if(roomEntityFromDB.isPresent()){
            RoomEntity roomEntity = roomEntityFromDB.get();
            if(roomEntity.getAvailable()){
                roomEntity.setAvailable(false);
                roomRepository.save(roomEntity);
                return true;
            }
        }
        return false;
    }

    @Override
    @Transactional
    public boolean bookRoom(List<RoomDTO> listOfRooms) {
        return listOfRooms.parallelStream()
                .map(this::bookRoom)
                .reduce(true, (subtotal, element) -> subtotal && element);
    }

    @Override
    public boolean cancelReservationRoom(Long roomId) {
        RoomEntity roomEntityFromDB = roomRepository.findRoomById(roomId)
                                        .orElseThrow(()->new RoomNotFoundException("Room not found"));

        if(!roomEntityFromDB.getAvailable()){
            HotelEntity hotel = roomRepository.findHotelByRoomId(roomId)
                                    .orElseThrow(()-> new HotelNotFoundException("Hotel not found"));

            LocalTime checkIn = hotel.getCheckIn();
            LocalTime now = LocalTime.now();
            long hours = Duration.between(checkIn, now).toHours();

            if(now.isBefore(checkIn) && hours>2L){
                roomEntityFromDB.setAvailable(true);
                roomRepository.save(roomEntityFromDB);
                return true;
            }
        }
        return false;
    }
}
