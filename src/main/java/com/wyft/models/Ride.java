package com.wyft.models;

public class Ride {
	private Integer rideID;

	private int pointA;
	private int pointB;
	private String status;

	public int getPointA() {
		return pointA;
	}

	public int getPointB() {
		return pointB;
	}

	public int getRideID() {
		return rideID;
	}

	public void setRideID(int rideID) {
		this.rideID = rideID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Ride(Integer rideID, int pointA, int pointB) {
		this.pointA = pointA;
		this.rideID = rideID;
		this.pointB = pointB;
	}
}
