import { Component, OnInit } from '@angular/core';
import { Vehicles } from '../../models/vehicles';
import { VehiclesService } from '../../services/vehicles.service';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnInit {

  vehicle: Vehicles[] = [];
  vehicles: Vehicles[] = [];
  asignar: Vehicles[] = [];
  public title: string = 'Lista vehiculos';

  tabIndex = 0;

  mostrarColumnas: string[] = ['id', 'Nombre', 'Identificacion', 'Placa', 'Marca', 'Modelo', 'Estado', 'Creado en'];
  mostrarColumnasVe: string[] = ['id', 'nombre', 'identificacion', 'placa', 'marca', 'modelo', 'estado', 'createAt'];

  constructor(private service: VehiclesService) { }

  ngOnInit(): void {

    this.service.list().subscribe(v => this.vehicle = v);

  }

  filtrar(nombre: string): void {

    nombre = nombre !== undefined? nombre.trim(): '';

    if(nombre !== ''){
      this.service.filterForValue(nombre).subscribe(v => this.asignar = v)
    }
  }

}
