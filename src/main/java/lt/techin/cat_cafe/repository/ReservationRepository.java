package lt.techin.cat_cafe.repository;

import lt.techin.cat_cafe.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {


}
