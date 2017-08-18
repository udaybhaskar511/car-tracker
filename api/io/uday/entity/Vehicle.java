package io.uday.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {
	
	@Id
	private String vin;
	private String make;
	private String model;
	private int year;
	private int redlineRpm;
	private float maxFuelVolume;
	private Timestamp lastServiceDate;
	//private Date lastServiceDate;
	
	
	public Timestamp getLastServiceDate() {
		return lastServiceDate;
	}
	public void setLastServiceDate(Timestamp lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getRedlineRpm() {
		return redlineRpm;
	}
	public void setRedlineRpm(int redlineRpm) {
		this.redlineRpm = redlineRpm;
	}
	public float getMaxFuelVolume() {
		return maxFuelVolume;
	}
	public void setMaxFuelVolume(float maxFuelVolume) {
		this.maxFuelVolume = maxFuelVolume;
	}
//	public Date getLastServiceDate() {
//		return lastServiceDate;
//	}
//	public void setLastServiceDate(Date lastServiceDate) {
//		this.lastServiceDate = lastServiceDate;
//	}
	
}
