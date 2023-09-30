package com.mycompany.rentCar.Repositories;

import com.mycompany.rentCar.Entities.Cars;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends CrudRepository<Cars, Long> {
}
