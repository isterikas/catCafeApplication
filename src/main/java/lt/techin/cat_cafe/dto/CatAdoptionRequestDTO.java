package lt.techin.cat_cafe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CatAdoptionRequestDTO(
        @NotNull
        @NotBlank
        @Pattern(regexp = "^[A-Z][a-zA-Z ]*$", message = "Only letters and spaces are allowed here. N.B. The name has to start with an uppercase letter.") String catName) {

}
