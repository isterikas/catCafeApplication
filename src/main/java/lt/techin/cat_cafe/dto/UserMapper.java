package lt.techin.cat_cafe.dto;

import lt.techin.cat_cafe.model.User;
import lt.techin.cat_cafe.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserMapper {


  public static UserResponseDTO toUserResponseDTO(User user) {


    return new UserResponseDTO(user.getId(), user.getUsername(), RoleMapper.roleResponseDTOList(user.getRoles()));
  }

}
