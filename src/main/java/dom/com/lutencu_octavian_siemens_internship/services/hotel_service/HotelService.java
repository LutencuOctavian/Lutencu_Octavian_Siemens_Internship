package dom.com.lutencu_octavian_siemens_internship.services.hotel_service;

import dom.com.lutencu_octavian_siemens_internship.dto.HotelDTO;
import dom.com.lutencu_octavian_siemens_internship.dto.RoomDTO;
import dom.com.lutencu_octavian_siemens_internship.dto.UserHotelRequestWithRangeDTO;
import dom.com.lutencu_octavian_siemens_internship.repositories.HotelRepository;
import dom.com.lutencu_octavian_siemens_internship.services.geographic_coordinate_system.GeographicCoordinateSystemInterface;
import dom.com.lutencu_octavian_siemens_internship.services.geographic_coordinate_system.LatitudeLongitudeMinMaxRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class HotelService implements IHotelService<UserHotelRequestWithRangeDTO, HotelDTO>{

    private final GeographicCoordinateSystemInterface<LatitudeLongitudeMinMaxRange, UserHotelRequestWithRangeDTO> geographicCoordinateSystem;
    private HotelRepository hotelRepository;
    @Autowired
    public HotelService(@Qualifier("naiveGeographicCoordinateSystemService")
                            GeographicCoordinateSystemInterface<LatitudeLongitudeMinMaxRange, UserHotelRequestWithRangeDTO> geographicCoordinateSystemInterface,
                            HotelRepository hotelRepository) {
        this.geographicCoordinateSystem = geographicCoordinateSystemInterface;
        this.hotelRepository = hotelRepository;
    }


    @Override
    public HotelDTO create(HotelDTO hotelDTO) {
        return null;
    }

    @Override
    public HotelDTO update(HotelDTO hotelDTO) {
        return null;
    }

    @Override
    public void delete(HotelDTO hotelDTO) {

    }

    @Override
    public HotelDTO findById(long id) {
        return null;
    }

    @Override
    public List<HotelDTO> searchHotelsInRange(UserHotelRequestWithRangeDTO userHotelRequestWithRangeDTO) {
        LatitudeLongitudeMinMaxRange latitudeLongitudeMinMaxRange = geographicCoordinateSystem.calculateMinMaxRangeOfLatitudeAndLongitude(userHotelRequestWithRangeDTO);
        List<HotelDTO> hotelDTOs = hotelRepository.findAllHotelsThaAreInRange(latitudeLongitudeMinMaxRange.getMinLatitude(),
                        latitudeLongitudeMinMaxRange.getMaxLatitude(),
                        latitudeLongitudeMinMaxRange.getMinLongitude(),
                        latitudeLongitudeMinMaxRange.getMaxLongitude())
                        .orElse(new ArrayList<>());

        return hotelDTOs.parallelStream()
                        .map(addToHotelAvailableRooms)
                        .collect(Collectors.toList());
    }

    private final Function<HotelDTO, HotelDTO> addToHotelAvailableRooms = hotel ->{
        List<RoomDTO> roomDTOs = hotelRepository.findAllAvailableRoomsForHotelById(hotel.getId()).orElse(new ArrayList<>());
        hotel.setRoomDTOList(roomDTOs);
        return hotel;
    };
}
