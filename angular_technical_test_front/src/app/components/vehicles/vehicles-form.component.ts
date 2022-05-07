import { Component, OnInit } from '@angular/core';
import { VehiclesService } from '../../services/vehicles.service';
import { Vehicles } from '../../models/vehicles';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vehicles-form',
  templateUrl: './vehicles-form.component.html',
  styleUrls: ['./vehicles-form.component.css']
})
export class VehiclesFormComponent implements OnInit {

  public title: string = 'Crear vehiculo';
  public vehicle: Vehicles = new Vehicles();

  constructor(private service: VehiclesService, private router: Router) { }

  ngOnInit(): void {

  }

  public create(): void {
    if(this.vehicle.driverName !== undefined) {
      this.service.create(this.vehicle).subscribe(v => {
        this.router.navigate(['/vehicles']);
      })
    }
    
  }

}
