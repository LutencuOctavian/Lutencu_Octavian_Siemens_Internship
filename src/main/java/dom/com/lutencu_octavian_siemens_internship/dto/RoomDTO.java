package dom.com.lutencu_octavian_siemens_internship.dto;

import dom.com.lutencu_octavian_siemens_internship.enteties.RoomEntity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@Data
public class RoomDTO {
    @NotNull
    private Long id;
    @NotNull
    private Integer roomNumber;
    @NotNull
    private String roomType;
    @NotNull
    private Integer price;
    @NotNull
    private Boolean isAvailable;

    public RoomDTO(Long id, Integer roomNumber, RoomEntity.RoomTypeEnum roomType, Integer price, Boolean isAvailable) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType.name();
        this.price = price;
        this.isAvailable = isAvailable;
    }
}
