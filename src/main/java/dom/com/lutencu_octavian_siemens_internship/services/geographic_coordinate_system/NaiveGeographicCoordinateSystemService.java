package dom.com.lutencu_octavian_siemens_internship.services.geographic_coordinate_system;

import dom.com.lutencu_octavian_siemens_internship.dto.UserHotelRequestWithRangeDTO;
import org.springframework.stereotype.Service;

@Service("naiveGeographicCoordinateSystemService")
public class NaiveGeographicCoordinateSystemService
        implements GeographicCoordinateSystemInterface<LatitudeLongitudeMinMaxRange, UserHotelRequestWithRangeDTO>{

    @Override
    public LatitudeLongitudeMinMaxRange calculateMinMaxRangeOfLatitudeAndLongitude(UserHotelRequestWithRangeDTO userHotelRequestWithRangeDTO) {
        double userLatitude = userHotelRequestWithRangeDTO.getLatitude();
        double userLongitude = userHotelRequestWithRangeDTO.getLongitude();
        double userRadiusInMeter = userHotelRequestWithRangeDTO.getRadiusInKm() * ONE_KM_IN_METER;

        double oneDegreeInMetersOfLatitude = oneDegreeInMetersForSpecificLatitude(userLatitude);
        double oneDegreeInMetersOfLongitude = oneDegreeInMetersForSpecificLongitude(userLongitude);

        double deltaLatitude = userRadiusInMeter/oneDegreeInMetersOfLatitude;
        double deltaLongitude = userRadiusInMeter/oneDegreeInMetersOfLongitude;

        return new LatitudeLongitudeMinMaxRange.LatitudeLongitudeMinMaxRangeBuilder()
                .minLatitude(userLatitude - deltaLatitude)
                .maxLatitude(userLatitude + deltaLatitude)
                .minLongitude(userLongitude - deltaLongitude)
                .maxLongitude(userLongitude + deltaLongitude)
                .build();
    }
}
