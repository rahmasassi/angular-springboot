package com.mycompany.rentCar.Services.Impl;

import com.mycompany.rentCar.CarDTO.CarDTO;
import com.mycompany.rentCar.Entities.Cars;
import com.mycompany.rentCar.Entities.Image;
import com.mycompany.rentCar.Repositories.CarsRepository;
import com.mycompany.rentCar.Services.CarsService;
import com.mycompany.rentCar.Services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarsServiceImpl implements CarsService {
    private final CarsRepository carsRepository;
    private final ImageService imageService;

    @Override
    public Cars addCar(Cars car) {
        return carsRepository.save(car);
    }

    @Override
    public Cars updatecar(Long carId, Cars updatedCar, MultipartFile newImage) throws IOException {
        Cars existingCar = carsRepository.findById(carId)
                .orElseThrow(() -> new EntityNotFoundException("La voiture avec l'ID " + carId + " n'a pas été trouvée"));

        existingCar.setName(updatedCar.getName());
        existingCar.setModel(updatedCar.getModel());
        existingCar.setNb_doors(updatedCar.getNb_doors());
        existingCar.setNb_places(updatedCar.getNb_places());
        existingCar.setAddress(updatedCar.getAddress());
        existingCar.setDescription((updatedCar.getDescription()));
        existingCar.setPrice_per_day(updatedCar.getPrice_per_day());
        existingCar.setRegistration_num(updatedCar.getRegistration_num());
        existingCar.setGearbox(updatedCar.getGearbox());

        Image existingImage = existingCar.getImage();
        if (existingImage == null) {
            Image newImageEntity = imageService.addImage(newImage, carId);
            existingCar.setImage(newImageEntity);
        } else {
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(newImage.getOriginalFilename()));
            String fileType = newImage.getContentType();
            byte[] data = newImage.getBytes();
            existingImage.setFileName(fileName);
            existingImage.setFileType(fileType);
            existingImage.setData(data);
        }
        return carsRepository.save(existingCar);
    }
     @Override
    public List<CarDTO> getAllCars() {
        List<Cars> allCars = (List<Cars>) carsRepository.findAll();
        return allCars.stream()
                .map(CarDTO::new)
                .collect(Collectors.toList());
    }
    @Override
    public Cars getCarById(Long carId) {
        return carsRepository.findById(carId)
                .orElse(null);
    }
}
