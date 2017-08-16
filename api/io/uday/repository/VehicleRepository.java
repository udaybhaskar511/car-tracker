package io.uday.repository;

import io.uday.entity.Vehicle;
import io.uday.entity.VehicleReading;

public interface VehicleRepository {

	Vehicle createVehicle(Vehicle vehicle);
	Vehicle updateVehicle(Vehicle vehicle);
	Vehicle findOne(String vin);
	VehicleReading createVehicleReading(VehicleReading vehicleReading);
	void createAlert(String result, String vin);
}
