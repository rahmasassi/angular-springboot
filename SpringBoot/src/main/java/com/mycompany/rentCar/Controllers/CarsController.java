package com.mycompany.rentCar.Controllers;

import com.mycompany.rentCar.CarDTO.CarDTO;
import com.mycompany.rentCar.Entities.Cars;
import com.mycompany.rentCar.Entities.Image;
import com.mycompany.rentCar.Services.CarsService;
import com.mycompany.rentCar.Services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/cars")
public class CarsController {
    private final CarsService carsService;
    private final ImageService imageService;

    @Autowired
    public CarsController(CarsService carsService, ImageService imageService) {
        this.carsService = carsService;
        this.imageService = imageService;
    }
    @PostMapping("/addCar")
    public ResponseEntity<String> addCarWithImage(
            @RequestParam("file") MultipartFile file,
            @ModelAttribute Cars car
    ) {
        try {
            Cars savedCar = carsService.addCar(car);
            Image addedImage = imageService.addImage(file, savedCar.getId());
            return ResponseEntity.ok("Voiture ajoutée avec succès avec l'ID : " + savedCar.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de l'ajout de la voiture : " + e.getMessage());
        }
    }

    @PutMapping("/update/{carId}")
    public ResponseEntity<String> update(
            @PathVariable Long carId,
            @ModelAttribute Cars updatedCar,
            @RequestParam("file") MultipartFile newImage
    ) {
        try {
            Cars update = carsService.updatecar(carId, updatedCar, newImage);
            return ResponseEntity.ok("Voiture mise à jour avec succès avec l'ID : " + update.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la mise à jour de la voiture : " + e.getMessage());
        }
    }
     @GetMapping("/getAllCars")
    public ResponseEntity<List<CarDTO>> getAllCars() {
        try {
            List<CarDTO> carsWithImages = carsService.getAllCars();
            System.out.println("carsWithImages");
            return ResponseEntity.ok(carsWithImages);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/getCarById/{carId}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable Long carId) {
        try {
            Cars car = carsService.getCarById(carId);
            if (car != null) {
                CarDTO carDTO = new CarDTO(car);
                return ResponseEntity.ok(carDTO);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
