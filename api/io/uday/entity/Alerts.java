package io.uday.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alerts {
	
	@Id
	private String id;
	private String vin;
	private String alertPriority;
	
	public Alerts(){
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getAlertPriority() {
		return alertPriority;
	}
	public void setAlertPriority(String alertPriority) {
		this.alertPriority = alertPriority;
	}	
	
}
