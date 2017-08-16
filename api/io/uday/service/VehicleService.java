package io.uday.service;

import java.util.List;

import io.uday.entity.Vehicle;
import io.uday.entity.VehicleReading;

public interface VehicleService {

	List<Vehicle> updateVehicle(List<Vehicle> vehiclesList);
	VehicleReading createVehicleReading(VehicleReading vehicleReading);
}
