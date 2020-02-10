package com.wyft.controllers;

import com.wyft.models.Ride;
import com.wyft.models.requests.RideRequest;
import com.wyft.services.RideService;

public class RideController {

	private RideService rideService;

	public RideController(RideService rideService) {
		this.rideService = rideService;
	}

	public String hailRide(Ride request){
		//invoke a service method which will try to create the ride, then return the result
		rideService.createRide(request);
		return "Ride has been hailed";
	}

	public String acceptRide(RideRequest request){
		//invoke a service method which will try to mark a ride as accepted, then return the result
		int status = rideService.acceptRide(request.getDriver(), request.getRideID());
		if (status == -2){
			return "Ride already Accepted";
		} else if (status == -1){
			return "Not in Range";
		} else {
			return "Proceed to point A";
		}
	}

	public String startRide(RideRequest request){
		//invoke a service method which will try to mark a ride as started, then return the result
		boolean startRideAllowed = rideService.startRide(request.getRideID(), request.getDriver().getLocation());

		if (startRideAllowed){
			return "Started";
		} else {
			return "Driver is not in range";
		}

	}

	public String endRide(RideRequest request){
		//invoke a service method which will try to mark a ride as ended, then return the result
		boolean endRideAllowed = rideService.endRide(request.getRideID(), request.getDriver().getLocation());
		if (endRideAllowed){
			return "Ride ended";
		}
		return "Cannot end ride, destination must be reached";
	}

	public String cancelRide(RideRequest request){
		//invoke a service method which will try to mark a ride as ended, then return the result
		int cancellationAllowed = rideService.cancelRide(request.getRideID(), request.getDriver().getLocation());
		if (cancellationAllowed == -1){
			return "Driver has arrived, cannot cancel";
		}
		if (cancellationAllowed == -2) {
			return "Ride already in progress, cannot cancel";
		}
		return "Cancelled";
	}

}
