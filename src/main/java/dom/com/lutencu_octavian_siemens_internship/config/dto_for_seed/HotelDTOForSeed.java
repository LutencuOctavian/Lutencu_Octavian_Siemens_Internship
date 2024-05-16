package dom.com.lutencu_octavian_siemens_internship.config.dto_for_seed;

import lombok.*;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HotelDTOForSeed {
    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
    private LocalTime checkIn;
    private LocalTime checkOut;

    private List<RoomDTOForSeed> rooms;
}
