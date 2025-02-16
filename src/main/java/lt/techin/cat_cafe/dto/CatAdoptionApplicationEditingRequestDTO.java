package lt.techin.cat_cafe.dto;

import jakarta.validation.constraints.Pattern;

public record CatAdoptionApplicationEditingRequestDTO(
        @Pattern(regexp = "^(?i)(approved|rejected)$", message = "Can be only approved or rejected"
        ) String status) {


}
