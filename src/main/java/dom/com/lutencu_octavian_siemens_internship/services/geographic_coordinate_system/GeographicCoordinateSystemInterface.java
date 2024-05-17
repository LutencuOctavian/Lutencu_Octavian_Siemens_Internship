package dom.com.lutencu_octavian_siemens_internship.services.geographic_coordinate_system;

public interface GeographicCoordinateSystemInterface<S, T> extends ConstantsForGeographicCoordinateSystem{

    S calculateMinMaxRangeOfLatitudeAndLongitude(T t);

    default double oneDegreeInMetersForSpecificLatitude(double degree){
        double radian = toRadians(degree);
        return LATITUDE_VAL1 +
                LATITUDE_VAL2 * Math.cos(2D * radian) +
                LATITUDE_VAL3 * Math.cos(4D * radian) +
                LATITUDE_VAL4 * Math.cos(6D * radian);
    }

    default double oneDegreeInMetersForSpecificLongitude(double degree){
        double radian = toRadians(degree);
        return LONGITUDE_VAL1 * Math.cos(radian) +
                LONGITUDE_VAL2 * Math.cos(3D * radian) +
                LONGITUDE_VAL3 * Math.cos(5D * radian);
    }

    default double toRadians(double degree){
        return Math.toRadians(degree);
    }
}
