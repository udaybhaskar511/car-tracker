package io.uday.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import io.uday.entity.Alerts;
import io.uday.entity.Vehicle;
import io.uday.entity.VehicleReading;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
		
	@Override
	public Vehicle createVehicle(Vehicle vehicle) {
		//System.out.println("readlineRPM:"+vehicle.getReadlineRpm());
		entityManager.persist(vehicle);
		return vehicle;
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		//System.out.println("readlineRPM:"+vehicle.getReadlineRpm());
		entityManager.merge(vehicle);
		return vehicle;
	}

	@Override
	public VehicleReading createVehicleReading(VehicleReading vehicleReading) {
		//System.out.println("readingTime:"+vehicleReading.getTimeStamp());
		entityManager.persist(vehicleReading);
		return vehicleReading;
	}

	@Override
	public Vehicle findOne(String vin) {
		return entityManager.find(Vehicle.class, vin);
	}

	@Override
	public void createAlert(String result, String vin) {
		
		//System.out.println("vin:"+vin+"result: "+result);
		Alerts alerts = new Alerts();
		alerts.setVin(vin);
		alerts.setAlertPriority(result);
		entityManager.persist(alerts);
	}

}
