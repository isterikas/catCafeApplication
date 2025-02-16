package lt.techin.cat_cafe.controller;

import jakarta.validation.Valid;
import lt.techin.cat_cafe.dto.*;
import lt.techin.cat_cafe.model.CatAdoption;
import lt.techin.cat_cafe.model.User;
import lt.techin.cat_cafe.repository.CatAdoptionRepository;
import lt.techin.cat_cafe.service.CatAdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adoptions")
public class AdoptionController {
  private final CatAdoptionService catAdoptionService;

  @Autowired
  public AdoptionController(CatAdoptionService catAdoptionService) {
    this.catAdoptionService = catAdoptionService;
  }


  @PostMapping("/apply")
  public ResponseEntity<?> createApplication(@Valid @RequestBody CatAdoptionRequestDTO catAdoptionRequestDTO, Authentication authentication) {

    User user = (User) authentication.getPrincipal();
    if (catAdoptionService.findAll().stream().filter(adoption -> adoption.getUser().getId() == user.getId()).anyMatch(adoption -> adoption.getCatName().equals(catAdoptionRequestDTO.catName()))) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User cannot apply for adoption of same cat twice.");
    }
    LocalDateTime now = LocalDateTime.now();
    CatAdoption catAdoption = new CatAdoption(user, catAdoptionRequestDTO.catName(), "PENDING", now);
    catAdoptionService.save(catAdoption);
    return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(catAdoption.getId())
            .toUri()).body(CatAdoptionMapper.toCatAdoptionResponseDTO(catAdoption));
  }

  @GetMapping
  public ResponseEntity<List<CatAdoptionCurrentStatusResponseDTO>> getCurrentStatus(Authentication authentication) {
    User user = (User) authentication.getPrincipal();
    List<CatAdoption> myAdoptions = catAdoptionService.findAll().stream().filter(adoption -> adoption.getUser().getId() == user.getId()).toList();
    return ResponseEntity.status(HttpStatus.OK).body(CatAdoptionMapper.toCatAdoptionCurrentStatusResponseDTOList(myAdoptions));
  }

  @GetMapping("/pending")
  public ResponseEntity<List<CatAdoptionCurrentStatusResponseDTO>> getAllPendingApplications() {
    return ResponseEntity.status(HttpStatus.OK).body(CatAdoptionMapper.toCatAdoptionCurrentStatusResponseDTOList(catAdoptionService.findAll()));
  }

  @PutMapping("/{adoptionId}/approve")
  public ResponseEntity<?> approveApplication(@PathVariable long adoptionId, @Valid @RequestBody CatAdoptionApplicationEditingRequestDTO catAdoptionApplicationEditingRequestDTO) {
    Optional<CatAdoption> catAdoption = catAdoptionService.findById(adoptionId);
    if (catAdoption.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Adoption application not found.");
    }
    catAdoption.get().setStatus(catAdoptionApplicationEditingRequestDTO.status().toUpperCase());
    catAdoptionService.save(catAdoption.get());
    return ResponseEntity.status(HttpStatus.OK).body(CatAdoptionMapper.toCatAdoptionCurrentStatusResponseDTO(catAdoption.get()));
  }


}
