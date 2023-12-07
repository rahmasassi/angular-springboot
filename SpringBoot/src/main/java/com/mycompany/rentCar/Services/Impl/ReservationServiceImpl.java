package com.mycompany.rentCar.Services.Impl;

import com.mycompany.rentCar.CarDTO.ReservationDTO;
import com.mycompany.rentCar.Entities.AppUser;
import com.mycompany.rentCar.Entities.Cars;
import com.mycompany.rentCar.Entities.Reservation;
import com.mycompany.rentCar.Repositories.CarsRepository;
import com.mycompany.rentCar.Repositories.ReservationRepository;
import com.mycompany.rentCar.Repositories.UserRepository;
import com.mycompany.rentCar.Services.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    private final UserRepository userRepository;

    private final CarsRepository carsRepository;

    @Override
    public void addReservation(Long carId, Reservation reservation, Long userId) {
        try {
            Optional<Cars> optionalCar = carsRepository.findById(carId);

        if (optionalCar.isPresent()) {
            Cars car = optionalCar.get();

            Optional<AppUser> optionalUser = userRepository.findById(userId);
            if (optionalUser.isPresent()) {
                AppUser user = optionalUser.get();

                Reservation newReservation = new Reservation();
                newReservation.setDateDebut(reservation.getDateDebut());
                newReservation.setDateFin(reservation.getDateFin());
                newReservation.setAddress(reservation.getAddress());
                newReservation.setPhone(reservation.getPhone());
                newReservation.setRegistration(reservation.getRegistration());
                newReservation.setStatus(reservation.isStatus());
                newReservation.setCar(car);
                newReservation.setUser(user);

                reservationRepository.save(newReservation);
            }}} catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
    }
    @Override
    public List<Reservation> getAllReservation(){ return (List<Reservation>) reservationRepository.findAll();}

    @Transactional
    public List<Reservation> getReservationsByCarId(long carId) {
        return reservationRepository.findByCarId(carId);
    }

    @Override
    public List<ReservationDTO> getReservationByUserId(Long userId) {
        List<Reservation> reservations = reservationRepository.findByUserId(userId);
        List<ReservationDTO> reservationDTOs = new ArrayList<>();

        for (Reservation reservation : reservations) {
            ReservationDTO reservationDTO = new ReservationDTO();
            reservationDTO.setReservationId(reservation.getId());
            reservationDTO.setDateDebut(reservation.getDateDebut().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            reservationDTO.setDateFin(reservation.getDateFin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            reservationDTO.setUsername(reservation.getUser().getUsername());

            reservationDTOs.add(reservationDTO);
        }
        return reservationDTOs;
    }

    @Override
    public List<Cars> getReservationByAgency(Long agencyId) {
        return carsRepository.findByAgencyId(agencyId);
    }
}
