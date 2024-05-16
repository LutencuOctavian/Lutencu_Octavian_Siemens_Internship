package dom.com.lutencu_octavian_siemens_internship.enteties;

import dom.com.lutencu_octavian_siemens_internship.config.dto_for_seed.HotelDTOForSeed;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="hotels", indexes = {@Index(name="ind_latitude", columnList = "latitude"),
                                    @Index(name="ind_longitude", columnList = "longitude")})
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

    @OneToMany(mappedBy = "hotelEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RoomEntity> roomEntityList;

    @OneToMany(mappedBy = "commentEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CommentEntity> commentEntityList;

    public HotelEntity() {}

    public HotelEntity(HotelDTOForSeed hotel) {
        this.name = hotel.getName();
        this.latitude = hotel.getLatitude();
        this.longitude = hotel.getLongitude();
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

    public List<RoomEntity> getRoomEntityList() {
        return roomEntityList;
    }

    public void setRoomEntityList(List<RoomEntity> roomEntityList) {
        this.roomEntityList = roomEntityList;
    }

    public List<CommentEntity> getCommentEntityList() {
        return commentEntityList;
    }

    public void setCommentEntityList(List<CommentEntity> commentEntityList) {
        this.commentEntityList = commentEntityList;
    }
}
