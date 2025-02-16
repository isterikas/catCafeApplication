package lt.techin.cat_cafe.dto;

import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lt.techin.cat_cafe.model.Role;
import lt.techin.cat_cafe.validation.UniqueUsername;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;


import java.util.List;

public record UserRequestDTO(
        @NotNull(message = "Username cannot be null.")
        @Length(min = 4, message = "Username must be at least 4 characters long.")
        @UniqueUsername
        String username,
        @NotNull(message = "Password cannot be null.")
        @Length(min = 10, message = "Password must be at least 10 characters long.")
        String password,
        @NonNull
        List<Role> roles
) {


}
