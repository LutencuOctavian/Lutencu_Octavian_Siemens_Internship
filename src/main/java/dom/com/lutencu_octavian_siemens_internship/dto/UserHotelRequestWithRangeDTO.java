package dom.com.lutencu_octavian_siemens_internship.dto;

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
    @Min(value = 1, message="radius must have radius bigger then 1")
    @Max(value = 12, message = "radius can not have value bigger then 12, earth surface behaviour not like a plan")
    private int radiusInKm;
}
