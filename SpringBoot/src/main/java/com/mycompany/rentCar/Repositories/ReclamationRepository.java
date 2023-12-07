package com.mycompany.rentCar.Repositories;

import com.mycompany.rentCar.Entities.Cars;
import com.mycompany.rentCar.Entities.Reclamation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation, Long> {
    List<Reclamation> findByAgencyId(Long userId);
}
