package dom.com.lutencu_octavian_siemens_internship.enteties;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="hotels")
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="hotel_name", nullable = false)
    private String name;

    @Column(name="latitude", nullable = false)
    private Double latitude;

    @Column(name="longitude", nullable = false)
    private Double longitude;

    @Column(name="comment", columnDefinition = "TEXT")
    private String comment;

    @OneToMany(mappedBy = "hotelEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RoomEntity> roomEntityList;

    public HotelEntity() {}

    public HotelEntity(Long id, String name, Double latitude,
                       Double longitude, String comment, List<RoomEntity> roomEntityList) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.comment = comment;
        this.roomEntityList = roomEntityList;
    }

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<RoomEntity> getRoomEntityList() {
        return roomEntityList;
    }

    public void setRoomEntityList(List<RoomEntity> roomEntityList) {
        this.roomEntityList = roomEntityList;
    }
}
