package com.mycompany.rentCar.Services;

import com.mycompany.rentCar.DTO.CarDTO;
import com.mycompany.rentCar.Entities.Cars;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CarsService {
    Cars addCar(Cars car);
    List<CarDTO> getAllCars();

}
