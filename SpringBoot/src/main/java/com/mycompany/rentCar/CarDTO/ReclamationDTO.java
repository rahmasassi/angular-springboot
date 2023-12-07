package com.mycompany.rentCar.CarDTO;

import com.mycompany.rentCar.Entities.Reclamation;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReclamationDTO {
    private long id;
    private String description;
    private Long userId;
    private Long agencyId;

    public ReclamationDTO(long id, String description, Long userId, Long agencyId) {
        this.id = id;
        this.description = description;
        this.userId = userId;
        this.agencyId = agencyId;
    }

    public ReclamationDTO(Reclamation reclamation) {
        this.id = reclamation.getId(); // Remplacez avec le getter approprié
        this.description = reclamation.getDescription(); // Remplacez avec le getter approprié
        this.userId = reclamation.getUserId();
        this.agencyId = reclamation.getAgencyId();
        // Initialiser d'autres champs si nécessaire
    }

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }

}
