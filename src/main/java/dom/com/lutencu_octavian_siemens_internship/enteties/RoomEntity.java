package dom.com.lutencu_octavian_siemens_internship.enteties;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="rooms")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Integer roomNumber;

    @Enumerated(EnumType.STRING)
    @Column(name="room_type", nullable = false)
    private RoomTypeEnum roomType;

    @Column(name="price", nullable = false)
    private Integer price;

    @Column(name="isAvailable", nullable = false, columnDefinition = "boolean")
    private Boolean isAvailable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="hotel_id")
    private HotelEntity hotelEntity;


    public enum RoomTypeEnum {
        SINGLE_ROOM("single_room"),
        DOUBLE_ROOM("double_room"),
        SUITE_ROOM("suite_room"),
        MATRIMONIAL_ROOM("matrimonial_room");
        private final String label;

        RoomTypeEnum(String label) {
            this.label = label;
        }

        public static RoomTypeEnum valueOfLabel(String label) {
            for (RoomTypeEnum roomType : values()) {
                if (roomType.label.equals(label)) {
                    return roomType;
                }
            }
            return null;
        }

        public static List<RoomTypeEnum> getAllValuesOfEnum() {
            return List.of(values());
        }

        @Override
        public String toString() {
            return label;
        }
    }

    public RoomEntity() {}

    public RoomEntity(Long id, Integer roomNumber, RoomTypeEnum roomType,
                      Integer price, Boolean isAvailable, HotelEntity hotelEntity) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = isAvailable;
        this.hotelEntity = hotelEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomTypeEnum getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypeEnum roomType) {
        this.roomType = roomType;
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

    public HotelEntity getHotelEntity() {
        return hotelEntity;
    }

    public void setHotelEntity(HotelEntity hotelEntity) {
        this.hotelEntity = hotelEntity;
    }
}
