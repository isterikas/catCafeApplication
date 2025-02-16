package lt.techin.cat_cafe.service;

import lt.techin.cat_cafe.model.Reservation;
import lt.techin.cat_cafe.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
  private final ReservationRepository reservationRepository;

  @Autowired
  public ReservationService(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  public Reservation save(Reservation savedReservation) {
    reservationRepository.save(savedReservation);
    return savedReservation;
  }

  public List<Reservation> findAllReservations() {
    return reservationRepository.findAll();
  }
}
