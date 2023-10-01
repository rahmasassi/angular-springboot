package com.mycompany.rentCar.Services.Impl;

import com.mycompany.rentCar.Entities.Cars;
import com.mycompany.rentCar.Repositories.CarsRepository;
import com.mycompany.rentCar.Services.CarsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class CarsServiceImpl implements CarsService {
    private final CarsRepository carsRepository;
    @Override
    public Cars addCar(Cars car) {
        return carsRepository.save(car);
    }




}
