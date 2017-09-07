import { Component, OnInit } from '@angular/core';
import {VehicleService} from '../vehicle-service/vehicle.service';
import {Sort} from '@angular/material';

@Component({
  selector: 'app-sort-vehiclealerts',
  templateUrl: './sort-vehiclealerts.component.html',
  styleUrls: ['./sort-vehiclealerts.component.css']
})
export class SortVehiclealertsComponent implements OnInit {
  vehiclesHighAlerts;
  constructor(private vehicleService: VehicleService) { }

  ngOnInit() {
    this.vehicleService.getHighAlerts().subscribe(
      highAlerts => this.vehiclesHighAlerts = highAlerts,
      error => console.log(error)
    );
  }
  sortData(sort: Sort) {
    const data = this.vehiclesHighAlerts.slice();
    if (!sort.active || sort.direction === '') {
      this.vehiclesHighAlerts = data;
      return;
    }

    this.vehiclesHighAlerts = data.sort((a, b) => {
      let isAsc = sort.direction === 'asc';
      if (sort.active) {
        return this.compare(a[3], b[3], isAsc);
      }
    });
  }
  compare(a, b, isAsc) {
    return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
  }
}
