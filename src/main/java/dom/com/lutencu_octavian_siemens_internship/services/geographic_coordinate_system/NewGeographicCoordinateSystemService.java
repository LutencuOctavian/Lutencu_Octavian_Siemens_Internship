package dom.com.lutencu_octavian_siemens_internship.services.geographic_coordinate_system;

import dom.com.lutencu_octavian_siemens_internship.dto.UserHotelRequestWithRangeDTO;
import org.springframework.stereotype.Service;

@Service("newGeographicCoordinateSystemService")
public class NewGeographicCoordinateSystemService implements
        GeographicCoordinateSystemInterface<LatitudeLongitudeMinMaxRange, UserHotelRequestWithRangeDTO>{
    @Override
    public LatitudeLongitudeMinMaxRange calculateMinMaxRangeOfLatitudeAndLongitude(UserHotelRequestWithRangeDTO userHotelRequestWithRangeDTO) {
        return null;
    }
}
