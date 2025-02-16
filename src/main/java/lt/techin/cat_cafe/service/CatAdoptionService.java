package lt.techin.cat_cafe.service;

import lt.techin.cat_cafe.model.CatAdoption;
import lt.techin.cat_cafe.repository.CatAdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatAdoptionService {

  private final CatAdoptionRepository catAdoptionRepository;

  @Autowired
  public CatAdoptionService(CatAdoptionRepository catAdoptionRepository) {
    this.catAdoptionRepository = catAdoptionRepository;
  }

  public CatAdoption save(CatAdoption catAdoption) {
    return catAdoptionRepository.save(catAdoption);
  }

  public List<CatAdoption> findAll() {
    return catAdoptionRepository.findAll();
  }

  public Optional<CatAdoption> findById(long adoptionId) {
    return catAdoptionRepository.findById(adoptionId);
  }
}
