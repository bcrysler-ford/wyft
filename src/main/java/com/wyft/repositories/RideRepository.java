package com.wyft.repositories;

import com.wyft.models.Ride;

import java.util.HashMap;
import java.util.Map;

public class RideRepository {

	private Map<Integer, Ride> rideDatabase;

	public RideRepository(){
		this.rideDatabase = new HashMap<Integer, Ride>();
	}

	public void addRide(Ride rideToAdd){
		rideToAdd.setStatus("Requested");
		this.rideDatabase.put(rideToAdd.getRideID(), rideToAdd);
	}

	public Ride getRideInfo(int rideID){
		return this.rideDatabase.get(rideID);
	}

	public void setRideToAccepted(Integer rideID){
		this.rideDatabase.get(rideID).setStatus("Accepted");
	}

	public void startRide(Integer rideID){
		this.rideDatabase.get(rideID).setStatus("In Progress");
	}

	public void endRide(Integer rideID){
		this.rideDatabase.get(rideID).setStatus("Ended");
	}

	public void cancelRide(Integer rideID) {
		this.rideDatabase.get(rideID).setStatus("Cancelled");
	}

	public int getSize(){
		return rideDatabase.size();
	}
}
