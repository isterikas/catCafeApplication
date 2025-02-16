package lt.techin.cat_cafe.dto;

import java.time.LocalDateTime;

public record CatAdoptionCurrentStatusResponseDTO(
        long id,
        UserResponseDTO user,
        String catName,
        String status,
        LocalDateTime applicationDate) {
}
