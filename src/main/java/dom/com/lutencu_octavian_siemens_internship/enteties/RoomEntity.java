package dom.com.lutencu_octavian_siemens_internship.enteties;

import dom.com.lutencu_octavian_siemens_internship.config.dto_for_seed.RoomDTOForSeed;
import dom.com.lutencu_octavian_siemens_internship.converters.BooleanConverter;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Entity
@Table(name="rooms", indexes = {@Index(name="ind_id", columnList = "id")})
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="room_number", nullable = false)
    private Integer roomNumber;

    @Enumerated(EnumType.STRING)
    @Column(name="room_type", nullable = false)
    private RoomTypeEnum roomType;

    @Column(name="price", nullable = false)
    private Integer price;

    @Convert(converter = BooleanConverter.class)
    @Column(name="isAvailable", nullable = false)
    private Boolean isAvailable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="hotel_id")
    private HotelEntity hotelEntity;

    public enum RoomTypeEnum {
        SINGLE_ROOM,
        DOUBLE_ROOM,
        SUITE_ROOM,
        MATRIMONIAL_ROOM;

        public static RoomTypeEnum getEnumTypeByVal(Integer val) {
            Map<Integer, RoomTypeEnum> mapOfIntAndEnum = Arrays.stream(values())
                    .collect(Collectors.toMap(enumValue -> enumValue.ordinal() + 1, valued -> valued));
            return mapOfIntAndEnum.get(val);
        }

        public static List<RoomTypeEnum> getAllValuesOfEnum() {
            return List.of(values());
        }
    }

    public RoomEntity() {}

    public RoomEntity(RoomDTOForSeed room, HotelEntity hotelEntity) {
        this.roomNumber = room.getRoomNumber();
        this.roomType = RoomTypeEnum.getEnumTypeByVal(room.getType());
        this.price = room.getPrice();
        this.isAvailable = room.getIsAvailable();
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
