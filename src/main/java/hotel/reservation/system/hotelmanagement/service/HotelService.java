package hotel.reservation.system.hotelmanagement.service;

import hotel.reservation.system.hotelmanagement.model.Hotel;
import hotel.reservation.system.hotelmanagement.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel makeHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public Hotel incrementNumberOfOccupiedRooms(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if (hotel != null) {
            hotel.setNumberOfRooms(hotel.getNumberOfRooms() + 1);
            return hotelRepository.save(hotel);
        }
        return null;
    }

    public Hotel decrementNumberOfOccupiedRooms(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if (hotel != null && hotel.getNumberOfRooms() > 0) {
            hotel.setNumberOfRooms(hotel.getNumberOfRooms() - 1);
            return hotelRepository.save(hotel);
        }
        return null;
    }

    public boolean areRoomsAvailable(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        return hotel != null && hotel.getNumberOfRooms() > 0;
    }
}


