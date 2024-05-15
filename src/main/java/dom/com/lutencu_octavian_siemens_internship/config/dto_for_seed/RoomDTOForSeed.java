package dom.com.lutencu_octavian_siemens_internship.config.dto_for_seed;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RoomDTOForSeed {

    private Integer roomNumber;
    private Integer type;
    private Integer price;
    @JsonFormat(shape = JsonFormat.Shape.BOOLEAN)
    private Boolean isAvailable;

    public RoomDTOForSeed() {}

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
