package lt.techin.cat_cafe.dto;

import lt.techin.cat_cafe.model.CatAdoption;

import java.util.List;

public class CatAdoptionMapper {

  public static CatAdoptionResponseDTO toCatAdoptionResponseDTO(CatAdoption catAdoption) {
    return new CatAdoptionResponseDTO(catAdoption.getId(), UserMapper.toUserResponseDTO(catAdoption.getUser()), catAdoption.getCatName(), catAdoption.getStatus(), catAdoption.getApplicationDate());
  }

  public static CatAdoptionCurrentStatusResponseDTO toCatAdoptionCurrentStatusResponseDTO(CatAdoption catAdoption) {
    return new CatAdoptionCurrentStatusResponseDTO(catAdoption.getId(), UserMapper.toUserResponseDTO(catAdoption.getUser()), catAdoption.getCatName(), catAdoption.getStatus(), catAdoption.getApplicationDate());
  }


  public static List<CatAdoptionCurrentStatusResponseDTO> toCatAdoptionCurrentStatusResponseDTOList(List<CatAdoption> myAdoptions) {
    return myAdoptions.stream().map(CatAdoptionMapper::toCatAdoptionCurrentStatusResponseDTO).toList();
  }
}
