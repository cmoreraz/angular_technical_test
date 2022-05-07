import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vehicles } from '../models/vehicles';

@Injectable({
  providedIn: 'root'
})
export class VehiclesService {

  private baseEndopoint = 'http://localhost:8080';
  protected cabeceras: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor( private http: HttpClient) { }

  public list(): Observable<Vehicles[]>{
    return this.http.get<Vehicles[]>(this.baseEndopoint);
  }

  public view(id: number): Observable<Vehicles>{
    return this.http.get<Vehicles>(`${this.baseEndopoint}/${id}`);
  }

  public create(vehicle: Vehicles): Observable<Vehicles>{
    return this.http.post<Vehicles>(this.baseEndopoint, vehicle,
      {headers: this.cabeceras});
  }

  public edit(vehicle: Vehicles): Observable<Vehicles> {
    return this.http.put<Vehicles>(`${this.baseEndopoint}/${vehicle.id}`, vehicle,
      { headers: this.cabeceras });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseEndopoint}/${id}`);
  }

  public filterForValue(term: string): Observable<Vehicles[]>{
    return this.http.get<Vehicles[]>(`${this.baseEndopoint}/filtrar/${term}`);
  }

}
