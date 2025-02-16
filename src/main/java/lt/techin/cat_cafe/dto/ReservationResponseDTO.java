package lt.techin.cat_cafe.dto;

import lt.techin.cat_cafe.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ReservationResponseDTO(long id,
                                     UserResponseDTO user,
                                     LocalDate dateOfReservation,
                                     String timeSlot,
                                     int numGuests) {
}
