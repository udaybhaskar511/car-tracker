import { Component, OnInit } from '@angular/core';
import {VehicleService} from '../vehicle-service/vehicle.service';

@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.css']
})
export class VehicleListComponent implements OnInit {
  vehiclesList;
  constructor(private vehicleService: VehicleService) { }

  ngOnInit(): void {
   this.vehicleService.getVehicles().subscribe(
     vehicleList => this.vehiclesList = vehicleList,
       error => console.log(error)
   );
  }
}
