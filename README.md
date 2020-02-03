# Problem Statement
Wyft is a startup company that wishes to create a ride sharing application. 
You have been tasked with creating the first draft of the backend system for the app. The requirements are as follows:
- A user must be able to request a ride from point A to point B.
- When a ride is requested, it must be registered in the database.
- A driver must be able to accept the ride request and receive the directions
- Only 1 driver can accept a ride request.
- A driver must be within 10 miles of the requested ride starting location to accept the ride
- The customer must be able to confirm/start the ride once the driver has accepted and arrives at point A
  - The customer should not be able to start the ride if the driver is not in range
- The user can cancel the ride if it has not been started and driver has not arrived
  - The user cannot cancel the ride if the driver has arrived
  - The user cannot cancel the ride if it has already started
- The driver can end the ride when they have arrived at point B
  - The driver cannot end the ride when they have not yet arrived
