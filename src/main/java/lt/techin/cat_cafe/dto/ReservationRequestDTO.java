package lt.techin.cat_cafe.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ReservationRequestDTO(
        @NotNull(message = "Date of reservation cannot be null.")
        @Future(message = "Date of reservation should be a future date.")
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate dateOfReservation,
        @NotNull
        @Pattern(regexp = "^[0-9:\\-\\s]+$", message = "Input can only consist of numbers, dashes and colons.")
        String timeSlot,
        @NotNull(message = "Number of guests cannot be null.")
        @Min(value = 1, message = "Minimum number of guests is 1.")
        @Max(value = 4, message = "Maximum number of guests is 4.")
        int numGuests) {


}
