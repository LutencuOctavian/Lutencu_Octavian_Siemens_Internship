package dom.com.lutencu_octavian_siemens_internship.config.dto_for_seed;

import java.util.List;

public class HotelDTOForSeed {
    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;

    private List<RoomDTOForSeed> rooms;

    public HotelDTOForSeed() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public List<RoomDTOForSeed> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDTOForSeed> rooms) {
        this.rooms = rooms;
    }
}
