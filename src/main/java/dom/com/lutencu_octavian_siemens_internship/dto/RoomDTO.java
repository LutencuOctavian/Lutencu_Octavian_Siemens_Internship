package dom.com.lutencu_octavian_siemens_internship.dto;

import dom.com.lutencu_octavian_siemens_internship.enteties.RoomEntity;
import lombok.*;

@NoArgsConstructor
@Data
public class RoomDTO {
    private Long id;
    private Integer roomNumber;
    private String roomType;
    private Integer price;
    private Boolean isAvailable;

    public RoomDTO(Long id, Integer roomNumber, RoomEntity.RoomTypeEnum roomType, Integer price, Boolean isAvailable) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType.name();
        this.price = price;
        this.isAvailable = isAvailable;
    }
}
