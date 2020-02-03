package com.wyft.models.requests;

import com.wyft.models.Driver;

public class UpdateRideRequest {
	private Driver driver;
	private Integer rideID;

	public Integer getRideID() {
		return rideID;
	}

	public Driver getDriver() {
		return driver;
	}

	public UpdateRideRequest(Driver driver, Integer rideID) {
		this.driver = driver;
		this.rideID = rideID;
	}
}
