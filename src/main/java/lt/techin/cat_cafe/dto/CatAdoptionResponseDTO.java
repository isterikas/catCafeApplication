package lt.techin.cat_cafe.dto;

import lt.techin.cat_cafe.model.User;

import java.time.LocalDateTime;

public record CatAdoptionResponseDTO(long id,
                                     UserResponseDTO user,
                                     String catName,
                                     String status,
                                     LocalDateTime applicationDate) {
}
