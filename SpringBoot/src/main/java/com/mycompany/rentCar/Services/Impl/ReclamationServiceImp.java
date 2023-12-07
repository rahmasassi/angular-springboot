package com.mycompany.rentCar.Services.Impl;
import com.mycompany.rentCar.CarDTO.CarDTO;
import com.mycompany.rentCar.CarDTO.ReclamationDTO;
import com.mycompany.rentCar.Entities.Agency;
import com.mycompany.rentCar.Entities.Cars;
import com.mycompany.rentCar.Entities.Image;
import com.mycompany.rentCar.Entities.Reclamation;
import com.mycompany.rentCar.Repositories.AgencyRepository;
import com.mycompany.rentCar.Repositories.ReclamationRepository;
import com.mycompany.rentCar.Services.ReclamationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class ReclamationServiceImp  implements ReclamationService {

    @Autowired
    private final ReclamationRepository reclamationRepository;
    private final AgencyRepository agencyRepository;

    @Override
    public Reclamation addReclamation(ReclamationDTO reclamationDTO) {
        Reclamation reclamation = new Reclamation();
        reclamation.setDescription(reclamationDTO.getDescription());
        reclamation.setUserId(reclamationDTO.getUserId());
        Long agencyId = reclamationDTO.getAgencyId();
        reclamation.setAgencyId(agencyId);
        return reclamationRepository.save(reclamation);
    }
    @Override
    public List<ReclamationDTO> getReclamationsByAgencyId(Long agencyId) {
      List<Reclamation> reclamations = reclamationRepository.findByAgencyId(agencyId);

      List<ReclamationDTO> reclamationDTOs = new ArrayList<>();
         for (Reclamation rec : reclamations) {
            ReclamationDTO reclamationDTO = new ReclamationDTO(rec);
            reclamationDTOs.add(reclamationDTO);
       }
    return reclamationDTOs;
}

    @Override
    public List<Reclamation> getAllReclamations() {
        return (List<Reclamation>) reclamationRepository.findAll();
    }

    @Override
    public void deleteReclamation(Long reclamationId) {
        Reclamation reclamation = reclamationRepository.findById(reclamationId).orElse(null);
        if (reclamation != null) {
            reclamationRepository.deleteById(reclamationId);
        }
        else {
            throw new EntityNotFoundException("Reclamation not found with id: " + reclamationId);
        }
    }


}
