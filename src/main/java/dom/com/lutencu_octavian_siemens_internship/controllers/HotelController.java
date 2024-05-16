package dom.com.lutencu_octavian_siemens_internship.controllers;

import dom.com.lutencu_octavian_siemens_internship.dto.HotelDTO;
import dom.com.lutencu_octavian_siemens_internship.dto.UserHotelRequestWithRangeDTO;
import dom.com.lutencu_octavian_siemens_internship.services.hotel_service.IHotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/hotel")
public class HotelController {

    private final IHotelService<UserHotelRequestWithRangeDTO, HotelDTO> hotelService;

    @Autowired
    public HotelController(IHotelService<UserHotelRequestWithRangeDTO, HotelDTO> hotelService) {
        this.hotelService = hotelService;
    }

    @RequestMapping(path="/search", method = RequestMethod.POST)
    public ResponseEntity<List<HotelDTO>> findNearByHotelsForUser(@RequestBody @Valid UserHotelRequestWithRangeDTO userHotelRequestWithRangeDTO){

        return ResponseEntity.status(200).body(hotelService.searchHotelsInRange(userHotelRequestWithRangeDTO));
    }
}
