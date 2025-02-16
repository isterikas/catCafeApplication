package lt.techin.cat_cafe.dto;

import lt.techin.cat_cafe.model.Role;

import java.util.List;

public record UserResponseDTO(
        long id,
        String username,
        List<RoleResponseDTO> roles) {


}
