package hotel.reservation.system.hotelmanagement.controller;

import hotel.reservation.system.hotelmanagement.service.HotelService;
import hotel.reservation.system.hotelmanagement.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> makeHotel(@Valid @RequestBody Hotel hotel) {
        try {
            return new ResponseEntity<>(hotelService.makeHotel(hotel), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        Hotel hotel = hotelService.getHotelById(id);
        if (hotel != null) {
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PatchMapping("/{id}/increment-rooms")
    public ResponseEntity<Hotel> incrementNumberOfOccupiedRooms(@PathVariable Long id) {
        Hotel hotel = hotelService.incrementNumberOfOccupiedRooms(id);
        if (hotel != null) {
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}/decrement-rooms")
    public ResponseEntity<Hotel> decrementNumberOfOccupiedRooms(@PathVariable Long id) {
        Hotel hotel = hotelService.decrementNumberOfOccupiedRooms(id);
        if (hotel != null) {
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/rooms-available")
    public ResponseEntity<Boolean> areRoomsAvailable(@PathVariable Long id) {
        boolean roomsAvailable = hotelService.areRoomsAvailable(id);
        return ResponseEntity.ok(roomsAvailable);
    }
}

