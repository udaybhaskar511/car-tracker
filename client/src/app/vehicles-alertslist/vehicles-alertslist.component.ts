import { Component, OnInit } from '@angular/core';
import {VehicleService} from '../vehicle-service/vehicle.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-vehicles-alertslist',
  templateUrl: './vehicles-alertslist.component.html',
  styleUrls: ['./vehicles-alertslist.component.css']
})
export class VehiclesAlertslistComponent implements OnInit {

  vehicleAlertsList;
  vin;
  constructor(private route: ActivatedRoute, private vehicleService: VehicleService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.vehicleService.getVehicleAlertList(params.vin).subscribe(
        vehicleAlerts => this.vehicleAlertsList = vehicleAlerts,
        error => console.log(error));
      this.vin = params.vin;
    }
    );
  }

}
