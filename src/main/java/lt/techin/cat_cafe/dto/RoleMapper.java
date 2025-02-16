package lt.techin.cat_cafe.dto;

import lt.techin.cat_cafe.model.Role;

import java.util.List;

public class RoleMapper {

  public static RoleResponseDTO toRoleResponseDTO(Role role) {
    return new RoleResponseDTO(role.getId(), role.getName());
  }

  public static List<RoleResponseDTO> roleResponseDTOList(List<Role> roles) {
    return roles.stream().map(RoleMapper::toRoleResponseDTO).toList();
  }

}
