package com.mycompany.rentCar.Services.Impl;

import com.mycompany.rentCar.DTO.CarDTO;
import com.mycompany.rentCar.Entities.Cars;
import com.mycompany.rentCar.Repositories.CarsRepository;
import com.mycompany.rentCar.Services.CarsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarsServiceImpl implements CarsService {
    private final CarsRepository carsRepository;
    @Override
    public Cars addCar(Cars car) {
        return carsRepository.save(car);
    }

    @Override
    public List<CarDTO> getAllCars() {
        List<Cars> allCars = (List<Cars>) carsRepository.findAll();
        return allCars.stream()
                .map(CarDTO::new)
                .collect(Collectors.toList());
    }



}
