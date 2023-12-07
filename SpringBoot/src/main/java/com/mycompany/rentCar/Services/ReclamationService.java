package com.mycompany.rentCar.Services;

import com.mycompany.rentCar.CarDTO.CarDTO;
import com.mycompany.rentCar.CarDTO.ReclamationDTO;
import com.mycompany.rentCar.Entities.Agency;
import com.mycompany.rentCar.Entities.Reclamation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReclamationService  {
    Reclamation addReclamation(ReclamationDTO reclamationDTO);
    @Transactional
    List<ReclamationDTO> getReclamationsByAgencyId(Long agencyId);
    List<Reclamation> getAllReclamations();
    void deleteReclamation(Long reclamationId);

}
