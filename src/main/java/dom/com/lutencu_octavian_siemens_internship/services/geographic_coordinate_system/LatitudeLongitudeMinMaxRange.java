package dom.com.lutencu_octavian_siemens_internship.services.geographic_coordinate_system;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LatitudeLongitudeMinMaxRange {

    private double minLatitude;
    private double maxLatitude;
    private double minLongitude;
    private double maxLongitude;
}
