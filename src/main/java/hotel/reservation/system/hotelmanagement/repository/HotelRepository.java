package hotel.reservation.system.hotelmanagement.repository;


import hotel.reservation.system.hotelmanagement.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
