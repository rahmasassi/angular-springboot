import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ApiResponse } from '../Models/ApiResponse';
import { Observable, catchError, map, throwError } from 'rxjs';
import { ListReclamation } from '../Models/reclamation';
import { ReclamationDTO } from '../Models/reclamationDTO';

@Injectable({
  providedIn: 'root'
})
export class ReclamationServiceService {
  private apiUrl = 'http://localhost:8081/api/reclamation';
  constructor(private http: HttpClient) { }
   addReclamation(reclamationDTO: ListReclamation, userId: number): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(`${this.apiUrl}/addReclamation?userId=${userId}`, reclamationDTO);
  }
  getReclamationByAgencyId(agencyId: number): Observable<ReclamationDTO[]> {
    const url = `${this.apiUrl}/getReclamationsByAgencyId/${agencyId}`;

    return this.http.get<ReclamationDTO[]>(url).pipe(
      catchError((error) => {
        console.error('Error fetching cars by agency ID', error);
        return throwError(error);
      })
    );
  }
  getAllReclamations(): Observable<ReclamationDTO[]> {
    const url = `${this.apiUrl}/getAllReclamation`;

    return this.http.get<ReclamationDTO[]>(url).pipe(
      catchError((error) => {
        console.error('Error fetching all reclamations', error);
        return throwError(error);
      })
    );
  }
  deleteReclamation(reclamationId: number): Observable<void> {
    const url = `${this.apiUrl}/deleteReclamation/${reclamationId}`;
  
    return this.http.delete(url, { responseType: 'text' }).pipe(
      catchError((error: any) => {
        console.error('Error deleting reclamation:', error);
        throw error; 
      }),
      map((response: any) => {
        console.log(response); 
        return; 
      })
    );
  }
  

}
