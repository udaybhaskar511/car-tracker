package io.uday.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.model.RuleBook;

import io.uday.entity.Vehicle;
import io.uday.entity.VehicleReading;
import io.uday.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	VehicleRepository repository;
	
	@Autowired
	RuleBook ruleBook;

	@Transactional
	public List<Vehicle> updateVehicle(List<Vehicle> vehiclesList) {
		
		List<Vehicle> outVehicleList = new ArrayList<>();
		
		vehiclesList.forEach(vehicle -> {
			Vehicle existing = repository.findOne(vehicle.getVin());
			if(existing == null){
				//System.out.println("readlineRPM:"+vehicle.getLastServiceDate());
				outVehicleList.add(repository.createVehicle(vehicle));
			}else{
				//System.out.println("readlineRPM:"+vehicle.getLastServiceDate());
				outVehicleList.add(repository.updateVehicle(vehicle));
			}
		});
		
		return outVehicleList;
	}

	@Transactional
	public VehicleReading createVehicleReading(VehicleReading vehicleReading) {
		//System.out.println("readingTime:"+vehicleReading.getTimeStamp());
		VehicleReading existingReading = repository.createVehicleReading(vehicleReading);
		
		Vehicle existing = repository.findOne(existingReading.getVin());
		if(existing != null && existingReading != null){
			//System.out.println("calling runalerts");
			runVehicleRules(existing, existingReading);
		}	
		return existingReading;
	}

	@Transactional
	public void runVehicleRules(Vehicle vehicle, VehicleReading vehicleReading){
		
		NameValueReferableMap facts = new FactMap<>();
		facts.setValue("readLineRpm", vehicle.getReadlineRpm());
		facts.setValue("engineRpm", vehicleReading.getEngineRpm());
		facts.setValue("fuelVolume", vehicleReading.getFuelVolume());
		facts.setValue("maxFuelVolume", vehicle.getMaxFuelVolume());
		facts.setValue("engineCoolantLow", vehicleReading.isEngineCoolantLow());
		facts.setValue("checkEngineLightOn", vehicleReading.isCheckEngineLightOn());
		facts.setValue("frontLeft", vehicleReading.getTires().getFrontLeft());
		facts.setValue("frontRight", vehicleReading.getTires().getFrontRight());
		facts.setValue("rearLeft", vehicleReading.getTires().getRearLeft());
		facts.setValue("rearRight", vehicleReading.getTires().getRearRight());
		//System.out.println("before running facts");
		ruleBook.run(facts);
		//System.out.println("after running facts: "+ruleBook.getResult().toString());
		
		ruleBook.getResult().ifPresent(result -> repository.createAlert(result.toString(), vehicleReading.getVin()));

	}
	
}
