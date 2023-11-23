import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, catchError, tap, throwError } from 'rxjs';
import { Cars } from '../Models/cars';
import { CarDTO } from '../Models/CarDTO';
@Injectable({
  providedIn: 'root'
})
export class CarsService {
  private searchResultsSubject: BehaviorSubject<any> = new BehaviorSubject([]);
  public searchResults$: Observable<any> = this.searchResultsSubject.asObservable();
  private apiUrl = 'http://localhost:8080/api/cars';
  private searchResults: CarDTO[] = [];


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

  getAllCars(): Observable<CarDTO[]> {
    return this.http.get<CarDTO[]>(`${this.apiUrl}/getAllCars`);
  }
  searchCars(searchTerm: string): Observable<CarDTO[]> {
    return this.http.get<CarDTO[]>(`${this.apiUrl}/search?searchTerm=${searchTerm}`);
  }
}
