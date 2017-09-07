import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {VehicleService} from '../vehicle-service/vehicle.service';

@Component({
  selector: 'app-vehicle-geolocation',
  templateUrl: './vehicle-geolocation.component.html',
  styleUrls: ['./vehicle-geolocation.component.css']
})
export class VehicleGeolocationComponent implements OnInit {
  vehiclesLatLong;
  vin;
  zoom = 4;
  lat; lon;
  constructor(private route: ActivatedRoute, private vehicleService: VehicleService) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.vehicleService.getVehicleGeolocation(params.vin).subscribe(
        vehiclesLatLong => this.vehiclesLatLong = vehiclesLatLong,
        // vehiclesLatLong => console.log(vehiclesLatLong),
        error => console.log(error)
      )
      this.vin = params.vin;
    });
  }
}
