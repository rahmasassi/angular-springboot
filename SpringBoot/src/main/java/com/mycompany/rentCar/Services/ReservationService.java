package com.mycompany.rentCar.Services;

import com.mycompany.rentCar.CarDTO.ReservationDTO;
import com.mycompany.rentCar.Entities.Cars;
import com.mycompany.rentCar.Entities.Reservation;
import com.mycompany.rentCar.Repositories.ReservationRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    List<Reservation> getAllReservation();

    public List<Reservation> getReservationsByCarId(long carId);

    @Transactional
    List<ReservationDTO> getReservationByUserId(Long userId);

    @Transactional
    List<Cars> getReservationByAgency(Long agencyId);

    void addReservation(Long carId, Reservation reservation, Long userId);
}
