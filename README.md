# Setup
Run this command if you have a GitHub SSH key set up on your device:
```
git clone -b startingPoint git@github.com:bcrysler-ford/wyft.git
```

Run this command if you need to authenticate with username and password:
```
git clone -b startingPoint https://github.com/bcrysler-ford/wyft.git
```

# Instructions
The above clone commands will get you the "starting point" of this codebase. Some basic framework is provided.
The controller/service/repository structure has been created for you, as well as a test suite.
2 passing tests and 1 failing test have been provided to you. The rest of the tests need to be implemented. A method name
and comment have been provided on the rest of the tests to guide you in writing them.
The Ford Foundational Services Engineer and the interview candidate will pair in a navigator/driver manner on this project.
TDD is to be followed to make the failing test pass, and to write the rest of the tests and code.


# Problem Statement
Wyft is a startup company that wishes to create a ride sharing application.
You have been tasked with creating the first draft of the backend system for the app. The requirements are as follows:
- A user must be able to request a ride from point A to point B.
- When a ride is requested, it must be registered in the database.
- A driver must be able to accept the ride request and receive the directions
- Only 1 driver can accept a ride request.
- A driver must be within 10 miles of the requested ride starting location to accept the ride
- The user must be able to confirm/start the ride once the driver has accepted and arrives at point A
- The user should not be able to start the ride if the driver is not in range
- The user can cancel the ride if it has not been started and driver has not arrived
- The user cannot cancel the ride if the driver has arrived
- The user cannot cancel the ride if it has already started
- The driver can end the ride when they have arrived at point B
- The driver cannot end the ride when they have not yet arrived
