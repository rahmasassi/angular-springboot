package com.mycompany.rentCar.Controllers;

import com.mycompany.rentCar.Entities.Cars;
import com.mycompany.rentCar.Entities.Image;
import com.mycompany.rentCar.Services.CarsService;
import com.mycompany.rentCar.Services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
            Cars update = carsService.updatecars(carId, updatedCar, newImage);
            return ResponseEntity.ok("Voiture mise à jour avec succès avec l'ID : " + update.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la mise à jour de la voiture : " + e.getMessage());
        }
    }
}
