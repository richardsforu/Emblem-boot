package com.cts.pss.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Fare {
	
	@Id
	@GeneratedValue
	private long fareId;
	private double fare;
	private String currency;
	public long getFareId() {
		return fareId;
	}
	public void setFareId(long fareId) {
		this.fareId = fareId;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	
	

}
