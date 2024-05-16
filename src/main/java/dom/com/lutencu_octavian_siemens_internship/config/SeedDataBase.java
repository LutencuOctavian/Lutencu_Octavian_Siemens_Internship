package dom.com.lutencu_octavian_siemens_internship.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dom.com.lutencu_octavian_siemens_internship.config.dto_for_seed.HotelDTOForSeed;
import dom.com.lutencu_octavian_siemens_internship.enteties.HotelEntity;
import dom.com.lutencu_octavian_siemens_internship.enteties.RoomEntity;
import dom.com.lutencu_octavian_siemens_internship.repositories.HotelRepository;
import dom.com.lutencu_octavian_siemens_internship.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalTime;
import java.util.List;

@Component
public class SeedDataBase {

    private static final String FILE_NAME = "json_db.txt";
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;


    @Autowired
    public SeedDataBase(HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

//    @EventListener
    public void seed(ContextRefreshedEvent event) throws IOException {

        String jsonString = readAuxiliarFile();
        ObjectMapper mapper = new ObjectMapper();
        List<HotelDTOForSeed> hotelList = mapper.readValue(jsonString, new TypeReference<>(){});
        LocalTime checkIn = LocalTime.of(14, 0, 0);
        LocalTime checkOut = LocalTime.of(12, 0, 0);


        hotelList.forEach(hotel->{
            hotel.setCheckIn(checkIn);
            hotel.setCheckOut(checkOut);
            final HotelEntity hotelEntity = hotelRepository.save(new HotelEntity(hotel));

            hotel.getRooms().parallelStream()
                    .map(room-> new RoomEntity(room, hotelEntity))
                    .forEach(roomRepository::save);
        });

    }

    private String readAuxiliarFile() throws IOException {
        File file = new File(SeedDataBase.FILE_NAME);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        StringBuilder stringBuilder = new StringBuilder();

        while ((st = br.readLine()) != null){
            stringBuilder.append(st.replaceAll("\\s+",""));
        }

        return stringBuilder.toString();
    }
}
