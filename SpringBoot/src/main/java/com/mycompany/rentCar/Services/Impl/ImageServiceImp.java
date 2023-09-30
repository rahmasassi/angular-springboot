package com.mycompany.rentCar.Services.Impl;

import com.mycompany.rentCar.Entities.Image;
import com.mycompany.rentCar.Services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageServiceImp implements ImageService{

    @Override
    public Image getImage(String id) {
        return null;
    }
}
