package com.mycompany.rentCar.Services;

import com.mycompany.rentCar.Entities.Cars;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface CarsService {
    Cars addCar(Cars car);
    Cars updatecar(Long carId, Cars updatedCar, MultipartFile newImage) throws IOException;
}
