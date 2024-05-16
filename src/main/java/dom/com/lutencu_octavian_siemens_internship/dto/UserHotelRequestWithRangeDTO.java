package dom.com.lutencu_octavian_siemens_internship.dto;

import dom.com.lutencu_octavian_siemens_internship.validators.RangeOneMeterAndTwelveKm;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserHotelRequestWithRangeDTO {

    @NotNull(message = "Latitude can not be null")
    private double latitude;
    @NotNull(message = "Longitude can not be null")
    private double longitude;
    @RangeOneMeterAndTwelveKm
    private Double radiusInKm;
}
