import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ProvidersComponent } from './components/providers/providers.component';
import { VehiclesComponent } from './components/vehicles/vehicles.component';
import { ProvidersFormComponent } from './components/providers/providers-form.component';
import { VehiclesFormComponent } from './components/vehicles/vehicles-form.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'vehicles'},
  {path: 'providers', component: ProvidersComponent},
  {path: 'providers/form', component: ProvidersFormComponent},
  {path: 'providers/form/:id', component: ProvidersComponent},
  {path: 'vehicles', component: VehiclesComponent},
  {path: 'vehicles/form', component: VehiclesFormComponent},
  {path: 'vehicles/form/:id', component: VehiclesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
