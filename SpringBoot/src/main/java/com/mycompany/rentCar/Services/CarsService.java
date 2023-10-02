package com.mycompany.rentCar.Services;

import com.mycompany.rentCar.CarDTO.CarDTO;
import com.mycompany.rentCar.Entities.Cars;

import java.util.List;


public interface CarsService {
    Cars addCar(Cars car);
    List<CarDTO> getAllCars();

}
