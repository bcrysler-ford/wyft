package com.wyft.controllers;

import com.wyft.models.Ride;
import com.wyft.models.requests.UpdateRideRequest;
import com.wyft.services.RideService;

public class RideController {

	private RideService rideService;

	public RideController(RideService rideService) {
		this.rideService = rideService;
	}

	public String hailRide(Ride request){
		rideService.createRide(request);
		return "Ride has been hailed";
	}

	public String acceptRide(UpdateRideRequest request){
		int proximity = rideService.acceptRide(request.getDriver(), request.getRideID());
		if (proximity == -2){
			return "Ride already Accepted";
		} else if (proximity == -1){
			return "Not in Range";
		} else {
			return "Proceed to point A";
		}
	}

	public String startRide(UpdateRideRequest request){
		boolean startRideAllowed = rideService.startRide(request.getRideID(), request.getDriver().getLocation());

		if (startRideAllowed){
			return "Started";
		} else {
			return "Driver is not in range";
		}

	}

	public String endRide(UpdateRideRequest request){
		boolean endRideAllowed = rideService.endRide(request.getRideID(), request.getDriver().getLocation());
		if (endRideAllowed){
			return "Ride ended";
		}
		return "Cannot end ride, destination must be reached";
	}

	public String cancelRide(UpdateRideRequest request){
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
