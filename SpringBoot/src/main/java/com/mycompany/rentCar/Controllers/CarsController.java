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
            // Ajoutez la voiture à la base de données en utilisant le service CarsService
            Cars savedCar = carsService.addCar(car);
            // Ajoutez l'image à la voiture en utilisant le service ImageService
            Image addedImage = imageService.addImage(file, savedCar.getId());
            // Vous pouvez retourner une réponse appropriée ici, par exemple, avec l'ID de la voiture
            return ResponseEntity.ok("Voiture ajoutée avec succès avec l'ID : " + savedCar.getId());
        } catch (Exception e) {
            // Gérez les erreurs ici, par exemple, renvoyez une réponse d'erreur
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de l'ajout de la voiture : " + e.getMessage());
        }
    }


}
