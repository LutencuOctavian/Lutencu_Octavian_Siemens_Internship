package dom.com.lutencu_octavian_siemens_internship.controllers;

import dom.com.lutencu_octavian_siemens_internship.dto.RoomDTO;
import dom.com.lutencu_octavian_siemens_internship.exceptions.RoomOrHotelNotFoundException;
import dom.com.lutencu_octavian_siemens_internship.services.room_service.IRoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/room")
public class RoomController {

    private final IRoomService<RoomDTO> roomService;

    @Autowired
    public RoomController(IRoomService<RoomDTO> roomService) {
        this.roomService = roomService;
    }

    @RequestMapping(path="book-one", method = RequestMethod.POST)
    public ResponseEntity<Object> bookRoom(@RequestBody @Valid RoomDTO roomDTO){
        try{
            return ResponseEntity.status(200).body(roomService.bookRoom(roomDTO));
        }catch(RuntimeException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @RequestMapping(path="book-multiple", method = RequestMethod.POST)
    public ResponseEntity<Object> bookListOfRoom(@RequestBody @Valid List<RoomDTO> listOfRoomDTO){
        try{
            return ResponseEntity.status(200).body(roomService.bookRoom(listOfRoomDTO));
        }catch(RuntimeException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @RequestMapping(path="cancel/{roomId}", method = RequestMethod.GET)
    public ResponseEntity<Object> cancelReservation(@PathVariable("roomId") Long roomId){
        try {
            return ResponseEntity.status(200).body(roomService.cancelReservationRoom(roomId));
        }catch (RoomOrHotelNotFoundException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
