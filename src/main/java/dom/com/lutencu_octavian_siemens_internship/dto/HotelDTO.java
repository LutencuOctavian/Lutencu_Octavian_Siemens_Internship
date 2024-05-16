package dom.com.lutencu_octavian_siemens_internship.dto;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Data
public class HotelDTO {
    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
    private List<CommentDTO>commentsList;
    private List<RoomDTO> roomDTOList;

    public HotelDTO(Long id, String name, Double latitude, Double longitude){
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
