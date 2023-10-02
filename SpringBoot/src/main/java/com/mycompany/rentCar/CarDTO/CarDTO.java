package com.mycompany.rentCar.CarDTO;

import com.mycompany.rentCar.Entities.Cars;
import com.mycompany.rentCar.Entities.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    private Long id;
    private String model;
    private int nb_doors;
    private int nb_places;
    private String address;
    private float price_per_day;
    private String registration_num;
    private String gearbox;
    private String imageId;
    private String imageName;
    private String imageFileType;
    // ... autres champs de l'image que vous voulez afficher

    public CarDTO(Cars car) {
        this.id = car.getId();
        this.model = car.getModel();
        this.nb_doors = car.getNb_doors();
        this.nb_places = car.getNb_places();
        this.address = car.getAddress();
        this.price_per_day = car.getPrice_per_day();
        this.registration_num = car.getRegistration_num();
        this.gearbox = car.getGearbox();

        Image image = car.getImage();
        if (image != null) {
            this.imageId = image.getId();
            this.imageName = image.getFileName();
            this.imageFileType = image.getFileType();
            // ... affectez d'autres champs de l'image
        }
    }
}