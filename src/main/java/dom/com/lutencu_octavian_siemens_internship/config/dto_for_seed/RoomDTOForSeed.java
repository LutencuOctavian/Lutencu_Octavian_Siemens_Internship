package dom.com.lutencu_octavian_siemens_internship.config.dto_for_seed;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomDTOForSeed {
    private Integer roomNumber;
    private Integer type;
    private Integer price;
    @JsonFormat(shape = JsonFormat.Shape.BOOLEAN)
    private Boolean isAvailable;
}
