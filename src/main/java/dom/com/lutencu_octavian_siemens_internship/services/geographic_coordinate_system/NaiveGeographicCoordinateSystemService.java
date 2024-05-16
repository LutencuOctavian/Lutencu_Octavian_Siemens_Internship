package dom.com.lutencu_octavian_siemens_internship.services.geographic_coordinate_system;

import dom.com.lutencu_octavian_siemens_internship.dto.UserHotelRequestWithRangeDTO;
import org.springframework.stereotype.Service;

@Service("naiveGeographicCoordinateSystemService")
public class NaiveGeographicCoordinateSystemService
        implements GeographicCoordinateSystemInterface<LatitudeLongitudeMinMaxRange, UserHotelRequestWithRangeDTO>,
                    ConstantsForGeographicCoordinateSystem{


    @Override
    public LatitudeLongitudeMinMaxRange calculateMinMaxRangeOfLatitudeAndLongitude(UserHotelRequestWithRangeDTO userHotelRequestWithRangeDTO) {
        double userLatitude = userHotelRequestWithRangeDTO.getLatitude();
        double userLongitude = userHotelRequestWithRangeDTO.getLongitude();
        double userRadiusInMeter = userHotelRequestWithRangeDTO.getRadiusInKm() * ConstantsForGeographicCoordinateSystem.ONE_KM_IN_METER;

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

    private double oneDegreeInMetersForSpecificLatitude(double degree){
        double radian = toRadians(degree);
        return ConstantsForGeographicCoordinateSystem.LATITUDE_VAL1 +
                ConstantsForGeographicCoordinateSystem.LATITUDE_VAL2 * Math.cos(2D * radian) +
                ConstantsForGeographicCoordinateSystem.LATITUDE_VAL3 * Math.cos(4D * radian) +
                ConstantsForGeographicCoordinateSystem.LATITUDE_VAL4 * Math.cos(6D * radian);
    }

    private double oneDegreeInMetersForSpecificLongitude(double degree){
        double radian = toRadians(degree);
        return ConstantsForGeographicCoordinateSystem.LONGITUDE_VAL1 * Math.cos(radian) +
                ConstantsForGeographicCoordinateSystem.LONGITUDE_VAL2 * Math.cos(3D * radian) +
                ConstantsForGeographicCoordinateSystem.LONGITUDE_VAL3 * Math.cos(5D * radian);
    }

    private double toRadians(double degree){
        return Math.toRadians(degree);
    }
}
