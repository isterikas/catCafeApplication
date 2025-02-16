package lt.techin.cat_cafe.repository;

import lt.techin.cat_cafe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findUserByUsername(String username);


}
