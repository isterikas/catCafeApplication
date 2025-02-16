package lt.techin.cat_cafe.service;

import lt.techin.cat_cafe.dto.RoleResponseDTO;
import lt.techin.cat_cafe.dto.UserRequestDTO;
import lt.techin.cat_cafe.model.Role;
import lt.techin.cat_cafe.model.User;
import lt.techin.cat_cafe.repository.RoleRepository;
import lt.techin.cat_cafe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public User saveUser(UserRequestDTO userRequestDTO) {
    List<Role> roles = userRequestDTO.roles().stream().map(role -> roleRepository.findById(role.getId()).get()).toList();
    User user = new User(userRequestDTO.username(), passwordEncoder.encode(userRequestDTO.password()), roles);
    userRepository.save(user);
    return user;
  }

  public Optional<User> findByUsername(String username) {
    return userRepository.findUserByUsername(username);
  }
}
