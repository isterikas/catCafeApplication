package lt.techin.cat_cafe.controller;

import jakarta.validation.Valid;
import lt.techin.cat_cafe.dto.ReservationMapper;
import lt.techin.cat_cafe.dto.ReservationRequestDTO;
import lt.techin.cat_cafe.dto.ReservationResponseDTO;
import lt.techin.cat_cafe.dto.UserMapper;
import lt.techin.cat_cafe.model.Reservation;
import lt.techin.cat_cafe.model.User;
import lt.techin.cat_cafe.service.ReservationService;
import lt.techin.cat_cafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {

  private final ReservationService reservationService;

  @Autowired
  public ReservationController(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  @PostMapping("/reservations")
  public ResponseEntity<?> postReservation(@Valid @RequestBody ReservationRequestDTO reservationRequestDTO, Authentication authentication) {
    User user = (User) authentication.getPrincipal();
    Reservation savedReservation = new Reservation(user, reservationRequestDTO.dateOfReservation(), reservationRequestDTO.timeSlot(), reservationRequestDTO.numGuests());
    reservationService.save(savedReservation);
    return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedReservation.getId())
            .toUri()).body(ReservationMapper.toReservationResponseDTO(savedReservation));
  }

  @GetMapping("/reservations")
  public ResponseEntity<List<ReservationResponseDTO>> getReservations(Authentication authentication) {
    User user = (User) authentication.getPrincipal();
    List<Reservation> myReservations = reservationService.findAllReservations().stream().filter(reservation -> reservation.getUser().getId() == user.getId()).toList();

    return ResponseEntity.status(HttpStatus.OK).body(ReservationMapper.toReservationResponseDTOList(myReservations));

  }


}
