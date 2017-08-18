package io.uday.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.uday.entity.Vehicle;
import io.uday.entity.VehicleReading;
import io.uday.service.VehicleService;

@RestController
@CrossOrigin(origins = "http://mocker.egen.io")
public class VehicleController {

	@Autowired
	VehicleService service;
	
	
	@RequestMapping(method = RequestMethod.POST, value="readings",
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public VehicleReading createVehicleReading(@RequestBody VehicleReading vehicleReading){
//		System.out.println("readingTime:"+vehicleReading.getTimeStamp());
		return service.createVehicleReading(vehicleReading);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="vehicles",
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Vehicle> updateVehicles(@RequestBody List<Vehicle> vehiclesList){
		
		//vehiclesList.forEach(vehicle->System.out.println("readlineRPM:"+vehicle.getReadlineRpm()));
		return service.updateVehicle(vehiclesList);
	}
}
