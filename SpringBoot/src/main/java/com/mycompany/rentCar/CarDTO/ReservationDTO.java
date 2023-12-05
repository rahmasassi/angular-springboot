package com.mycompany.rentCar.CarDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
public class ReservationDTO {

    private Long reservationId;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    private String username;

    public ReservationDTO(LocalDate dateDebut, LocalDate dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
}
