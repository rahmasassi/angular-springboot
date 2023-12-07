package com.mycompany.rentCar.Controllers;

import com.mycompany.rentCar.ApiResponse;
import com.mycompany.rentCar.CarDTO.CarDTO;
import com.mycompany.rentCar.CarDTO.ReclamationDTO;
import com.mycompany.rentCar.Entities.Agency;
import com.mycompany.rentCar.Entities.Reclamation;
import com.mycompany.rentCar.Services.ReclamationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/reclamation")
@AllArgsConstructor
public class ReclamationController {
    private final ReclamationService reclamationService;
    @PostMapping("/addReclamation")
    public ResponseEntity<ApiResponse> addReclamation(
            @Valid @RequestBody ReclamationDTO reclamationDTO,
            @RequestParam("userId") Long userId
    ) {
        try {
            reclamationDTO.setUserId(userId);
            Reclamation savedReclamation = reclamationService.addReclamation(reclamationDTO);
            ApiResponse response = new ApiResponse("Réclamation ajoutée avec succès avec l'ID : " + savedReclamation.getId(), savedReclamation.getId());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Erreur lors de l'ajout de la réclamation : " + e.getMessage(), null));
        }
    }
    @GetMapping("/getReclamationsByAgencyId/{agencyId}")
    public ResponseEntity<List<ReclamationDTO>> getReclamationByAgencyId(@PathVariable Long agencyId) {
    try {
        List<ReclamationDTO> reclamationByAgency = reclamationService.getReclamationsByAgencyId(agencyId);
        return ResponseEntity.ok(reclamationByAgency);
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
    }
}
    @GetMapping("/getAllReclamation")
    public ResponseEntity<List<Reclamation>> getAllReclamations() {
        List<Reclamation> reclamations = reclamationService.getAllReclamations();
        return ResponseEntity.ok(reclamations);
    }
    @DeleteMapping("/deleteReclamation/{reclamationId}")
    public ResponseEntity<String> deleteReclamation(@PathVariable Long reclamationId) {
        try {
            reclamationService.deleteReclamation(reclamationId);
            return new ResponseEntity<>("Reclamation deleted successfully", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Reclamation not found with id: " + reclamationId, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting the reclamation", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
