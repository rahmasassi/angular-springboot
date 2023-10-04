import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cars } from '../Models/cars';
@Injectable({
  providedIn: 'root'
})
export class CarsService {
  private apiUrl = 'http://localhost:8081/api/cars';

  
  constructor(private http: HttpClient) { }

  addCarWithImage(carData: FormData): Observable<any> {
    return this.http.post(`${this.apiUrl}/addCar`, carData);
  }

  getCarById(carId: number): Observable<Cars> {
    return this.http.get<Cars>(`${this.apiUrl}/getCarById/${carId}`);
  }

  updateStudent(carId: number, value: any): Observable<Object> {  
    return this.http.post(`${this.apiUrl}/update/${carId}`, value);  
  }  
}
