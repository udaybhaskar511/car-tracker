import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/throw';

@Injectable()
export class VehicleService {
  constructor(private http: Http) { }
  getVehicles(): Observable<any> {
    return this.http.get('http://localhost:8080/car-tracker/api/vehicleList')
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
  getVehicleAlertList(vin): Observable<any> {
    return this.http.get (`http://localhost:8080/car-tracker/api/alerts/${vin}`)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
  getHighAlerts(): Observable<any> {
    return this.http.get('http://localhost:8080/car-tracker/api/highalerts')
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
  getVehicleGeolocation(vin): Observable<any> {
    return this.http.get (`http://localhost:8080/car-tracker/api/vehiclegeolocation/${vin}`)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
}
