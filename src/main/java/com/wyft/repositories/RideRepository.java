package com.wyft.repositories;

import com.wyft.models.Ride;

import java.util.HashMap;
import java.util.Map;

public class RideRepository {

	//Treat this as the database for rides. Integer is the Ride ID, Ride is the corresponding Ride object.
	private Map<Integer, Ride> rideDatabase;

	public RideRepository(){
		this.rideDatabase = new HashMap<Integer, Ride>();
	}

	public void addRide(Ride rideToAdd){
		//add a ride to the database.
		rideToAdd.setStatus("Requested");
		this.rideDatabase.put(rideToAdd.getRideID(), rideToAdd);
	}

	public Ride getRideInfo(int rideID){
		//retrieve a ride object
		return this.rideDatabase.get(rideID);
	}

	public void setRideToAccepted(Integer rideID){
		//get a ride from the database, and set its status to Accepted
		this.rideDatabase.get(rideID).setStatus("Accepted");
	}

	public void startRide(Integer rideID){
		//get a ride from the database, and set its status to In Progress
		this.rideDatabase.get(rideID).setStatus("In Progress");
	}

	public void endRide(Integer rideID){
		//get a ride from the database, and set its status to Ended
		this.rideDatabase.get(rideID).setStatus("Ended");
	}

	public void cancelRide(Integer rideID) {
		//get a ride from the database, and set its status to Cancelled
		this.rideDatabase.get(rideID).setStatus("Cancelled");
	}

	public int getSize(){
		return rideDatabase.size();
	}
}
