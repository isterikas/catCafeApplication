package lt.techin.cat_cafe.dto;

import lt.techin.cat_cafe.model.Reservation;

import java.util.List;

public class ReservationMapper {

  public static ReservationResponseDTO toReservationResponseDTO(Reservation reservation) {
    return new ReservationResponseDTO(reservation.getId(), UserMapper.toUserResponseDTO(reservation.getUser()), reservation.getDateOfReservation(), reservation.getTimeSlot(), reservation.getNumGuests());
  }

  public static List<ReservationResponseDTO> toReservationResponseDTOList(List<Reservation> reservations) {
    return reservations.stream().map(ReservationMapper::toReservationResponseDTO).toList();
  }

}
