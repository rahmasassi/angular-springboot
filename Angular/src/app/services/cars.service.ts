import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CarsService {
  private apiUrl = 'http://localhost:8080/api/cars';

  
  constructor(private http: HttpClient) { }

  addCarWithImage(carData: FormData): Observable<any> {
    return this.http.post(`${this.apiUrl}/addCar`, carData);
  }
}
