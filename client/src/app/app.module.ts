import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import {HttpModule} from '@angular/http';
import {VehicleService} from './vehicle-service/vehicle.service';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';
import { VehiclesAlertslistComponent } from './vehicles-alertslist/vehicles-alertslist.component';
import { SortVehiclealertsComponent } from './sort-vehiclealerts/sort-vehiclealerts.component';
import { MdSortModule } from '@angular/material';
import { VehicleGeolocationComponent } from './vehicle-geolocation/vehicle-geolocation.component';
import { AgmCoreModule } from '@agm/core';

const appRoutes: Routes = [
  { path: 'vehicles', component: VehicleListComponent },
  { path: 'vehicles/:vin', component: VehiclesAlertslistComponent },
  { path: 'vehiclegeolocation/:vin', component: VehicleGeolocationComponent},
  { path: 'sorthighalerts', component: SortVehiclealertsComponent},
  { path: '', redirectTo: '/vehicles', pathMatch: 'full' },
];

@NgModule({
  declarations: [
    AppComponent,
    VehicleListComponent,
    VehiclesAlertslistComponent,
    SortVehiclealertsComponent,
    VehicleGeolocationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    MdSortModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyCIYUcxTr-JWf05WsZU58iaSiX3ckPnuNI'
    }),
    RouterModule.forRoot(appRoutes),
  ],
  providers: [VehicleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
