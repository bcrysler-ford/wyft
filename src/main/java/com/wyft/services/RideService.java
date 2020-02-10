package com.wyft.services;

import com.wyft.models.Driver;
import com.wyft.models.Ride;
import com.wyft.repositories.RideRepository;

public class RideService {

	private RideRepository rideRepository;

	public RideService (RideRepository rideRepository){
		this.rideRepository = rideRepository;
	}

	public void createRide(Ride rideToCreate){
		rideRepository.addRide(rideToCreate);
	}

	public int acceptRide(Driver driver, Integer acceptedRideID){
	    //check the logic for whether or not a ride can be accepted, then invoke a repository method to accept it
		Ride acceptedRide = rideRepository.getRideInfo(acceptedRideID);

		if (acceptedRide.getStatus().equals("Accepted")){
			return -2;
		}

		int proximity = Math.abs(acceptedRide.getPointA() - driver.getLocation());
		if (proximity < 10){
			rideRepository.setRideToAccepted(acceptedRideID);
			return 1;
		} else if (proximity > 10){
			return -1;
		}
		return -999;
	}

	public boolean startRide(int rideID, int driverLocation){
	    //check the logic for whether or not a ride can be started, then invoke a repository method to start it
		Ride rideToStart = rideRepository.getRideInfo(rideID);
		if(rideToStart.getStatus().equals("Accepted") && driverLocation == rideToStart.getPointA()){
			rideRepository.startRide(rideID);
			return true;
		}
		return false;
	}

	public boolean endRide(int rideID, int driverLocation){
	    //check the logic for whether or not a ride can be started, then invoke a repository method to start it
		Ride rideToEnd = rideRepository.getRideInfo(rideID);

		if (driverLocation == rideToEnd.getPointB()){
			rideRepository.endRide(rideID);
			return true;
		}
		return false;
	}

	public int cancelRide(int rideID, int driverLocation) {
	    //check the logic for whether or not a ride can be cancelled, then invoke a repository method to cancel it
		Ride rideToCancel = rideRepository.getRideInfo(rideID);

		if (driverLocation == rideToCancel.getPointA()) {
			return -1;
		}

		if (rideToCancel.getStatus().equals("In Progress")) {
			return -2;
		}

		rideRepository.cancelRide(rideID);
		return 1;
	}
}
