package dom.com.lutencu_octavian_siemens_internship.controllers;

import dom.com.lutencu_octavian_siemens_internship.dto.CommentDTO;
import dom.com.lutencu_octavian_siemens_internship.exceptions.HotelNotFoundException;
import dom.com.lutencu_octavian_siemens_internship.exceptions.UserNotFoundException;
import dom.com.lutencu_octavian_siemens_internship.services.comment_service.ICommentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/comment")
public class CommentController {
    private final ICommentService<CommentDTO> commentService;

    public CommentController(ICommentService<CommentDTO> commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public ResponseEntity<Object> createNewComment(@RequestBody @Valid CommentDTO commentDTO){
        try{
            return ResponseEntity.status(200).body(commentService.create(commentDTO));
        }catch(UserNotFoundException | HotelNotFoundException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @RequestMapping(path = "/search-for-hotel", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllCommentsForSpecificHotel(@RequestParam("hotelId") Long hotelId){
        try{
            return ResponseEntity.status(200).body(commentService.findAllCommentsForHotel(hotelId));
        }catch(RuntimeException ex){
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }

    @RequestMapping(path = "/search-for-user", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllCommentsForSpecificUser(@RequestParam("userId") Long userId){
        try{
            return ResponseEntity.status(200).body(commentService.findAllCommentsForUser(userId));
        }catch(RuntimeException ex){
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }

    @RequestMapping(path = "/search-for-user-hotel", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllCommentsForSpecificUserHotel(@RequestParam("userId") Long userId, @RequestParam("hotelId") Long hotelId){
        try{
            return ResponseEntity.status(200).body(commentService.findAllCommentsGivenByUserToHotel(userId, hotelId));
        }catch(RuntimeException ex){
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }
}
