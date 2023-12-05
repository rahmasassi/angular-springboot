package com.mycompany.rentCar.Controllers;

import com.mycompany.rentCar.CarDTO.ReservationDTO;
import com.mycompany.rentCar.Entities.Cars;
import com.mycompany.rentCar.Entities.Reservation;
import com.mycompany.rentCar.Repositories.CarsRepository;
import com.mycompany.rentCar.Repositories.ReservationRepository;
import com.mycompany.rentCar.Services.CarsService;
import com.mycompany.rentCar.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    private final CarsRepository carsRepository;
    private final ReservationRepository reservationRepository;
    private final CarsService carsService;

    @Autowired
    public ReservationController(ReservationService reservationService, CarsRepository carsRepository, ReservationRepository reservationRepository, CarsService carsService) {
        this.reservationService = reservationService;
        this.carsRepository = carsRepository;
        this.reservationRepository = reservationRepository;
        this.carsService = carsService;
    }

    @PostMapping("/addReservation/{car_id}")
    public ResponseEntity<String> addReservation(@PathVariable(value = "car_id") Long car_id, @RequestBody Reservation reservation, @RequestParam(value = "userId") Long userId) {
            reservationService.addReservation(car_id, reservation, userId);
            return ResponseEntity.ok("Add reservation successufly");
    }

    @GetMapping("/getAllReservation")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservation();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/reservations/{agencyId}")
    public ResponseEntity<List<Reservation>> getReservationByAgencyId (@PathVariable long agencyId) {

        List<Reservation> reservations = reservationService.getAllReservation();
        List<Cars> cars = reservationService.getReservationByAgency(agencyId);
        List<Reservation> matchingReservations = new ArrayList<>();

        for (Reservation reservation : reservations) {
            if (reservation.getCar() != null) {
                long carIdInReservation = reservation.getCar().getId();

                for (Cars car : cars) {
                    if (car.getId() == carIdInReservation) {
                        matchingReservations.add(reservation);
                    }
                }
            }
        }

        return ResponseEntity.ok(matchingReservations);
    }

    @GetMapping("/getReservation/{car_id}")
    public  ResponseEntity<List<LocalDate>> getReservationsByCarId(@PathVariable long car_id) {
        List<Reservation> reservations = reservationService.getReservationsByCarId(car_id);
        List<ReservationDTO> reservationDates = new ArrayList<>();
        List<LocalDate> allDates = new ArrayList<>();
        for (Reservation reservation : reservations) {
            LocalDate dateDebut = reservation.getDateDebut().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate dateFin = reservation.getDateFin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            while (!dateDebut.isAfter(dateFin)) {
                allDates.add(dateDebut);
                dateDebut = dateDebut.plusDays(1);
            }
            }
        return  new ResponseEntity<>(allDates, HttpStatus.OK);
    }

    @GetMapping("/getReservationsByUserId/{user_id}")
    public ResponseEntity<List<ReservationDTO>> getReservationsByUserId(@PathVariable long user_id) {
        List<ReservationDTO> reservationDTOs = reservationService.getReservationByUserId(user_id);
        return new ResponseEntity<>(reservationDTOs, HttpStatus.OK);
    }
}
