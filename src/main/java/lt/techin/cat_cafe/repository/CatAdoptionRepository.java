package lt.techin.cat_cafe.repository;

import lt.techin.cat_cafe.model.CatAdoption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatAdoptionRepository extends JpaRepository<CatAdoption, Long> {


}
