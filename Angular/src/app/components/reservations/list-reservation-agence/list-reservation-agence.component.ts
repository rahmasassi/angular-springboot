import { Component, OnInit } from '@angular/core';
import { CarReservationAgence } from '../../../Models/list-reservation-agence.model';
import { format } from 'date-fns';
import { Reservation } from 'src/app/Models/reservation';
import { ReservationService } from 'src/app/services/reservation.service';
import { AuthenticateService } from 'src/app/services/authenticate.service';

@Component({
  selector: 'app-list-reservation-agence',
  templateUrl: './list-reservation-agence.component.html',
  styleUrls: ['./list-reservation-agence.component.css']
})
export class ListReservationAgenceComponent implements OnInit {

  reservations: Reservation[] = [];

  constructor(private reservationService: ReservationService, private authService: AuthenticateService) {}

  ngOnInit(): void {
    const agencyId = this.authService.getCurrentUserId();
    console.log("id user", agencyId);
    this.reservationService.getReservationsByAgency(agencyId).subscribe(
      (reservations) => {
        this.reservations = reservations;
        console.log('Reservations:', this.reservations);
      },
      (error) => {
        console.error('Error fetching reservations:', error);
      }
    );
  }
}