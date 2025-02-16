package lt.techin.cat_cafe.service;

import lt.techin.cat_cafe.repository.CatAdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatAdoptionService {

  private final CatAdoptionRepository catAdoptionRepository;

  @Autowired
  public CatAdoptionService(CatAdoptionRepository catAdoptionRepository) {
    this.catAdoptionRepository = catAdoptionRepository;
  }
}
