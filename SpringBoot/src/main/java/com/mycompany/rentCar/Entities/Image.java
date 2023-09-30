package com.mycompany.rentCar.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] data;

    @OneToOne
    @JoinColumn(name = "Car_id")
    private Cars cars;
}

