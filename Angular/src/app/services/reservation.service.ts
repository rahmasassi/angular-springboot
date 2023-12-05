import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, tap, throwError } from 'rxjs';
import { Reservation } from '../Models/reservation';
import { AuthenticateService } from './authenticate.service';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private apiUrl = 'http://localhost:8081/api/reservation';

  constructor(private http: HttpClient, private authService: AuthenticateService) { }

  addReservation(carId: number, userId: number, reservationData: any): Observable<any> {
    const url = `${this.apiUrl}/addReservation/${carId}?userId=${userId}`;
    return this.http.post(url, reservationData).pipe(
      tap(
        response => console.log('Error request HTTP :', response),
        error => console.error('Error request :', error)
      )
    );
  }  
  
  getAvailableDates(carId:number):Observable<any>{
    return this.http.get(`${this.apiUrl}/getReservation/${carId}`);
  }

  getReservationsByUserId(userId: number): Observable<Reservation[]> {
    const url = `${this.apiUrl}/getReservationsByUserId/${userId}`;
    return this.http.get<Reservation[]>(url);
  }

  getReservationsByAgency(agencyId: number): Observable<Reservation[]> {
    const url = `${this.apiUrl}/reservations/${agencyId}`;
    return this.http.get<Reservation[]>(url);
  }
}
