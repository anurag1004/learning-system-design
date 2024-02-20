package ridesharingapp.orchestrator;

import ridesharingapp.model.enums.Gender;
import ridesharingapp.model.exceptions.NoSuchUserFoundException;
import ridesharingapp.model.ride.Ride;
import ridesharingapp.model.route.Route;
import ridesharingapp.model.user.User;
import ridesharingapp.model.vehicle.Vehicle;
import ridesharingapp.service.RideService;
import ridesharingapp.service.UserService;
import ridesharingapp.strategy.PreferenceStrategy;

import java.time.LocalDateTime;
import java.util.Optional;

public class RideSharingApp {
    private final UserService userService;
    private final RideService rideService;

    public RideSharingApp(PreferenceStrategy preferenceStrategy){
        userService = new UserService();
        rideService = new RideService(preferenceStrategy);
    }
    public User createUser(String name, String gender, int age){
        return userService.createUser(name, gender, age);
    }

    public void addVehicle(String userName, String vehicleName, String regNo, int seats) throws NoSuchUserFoundException {
        User user = userService.getUser(userName);
        userService.addUserVehicle(userName, new Vehicle(vehicleName, regNo, user, seats));
    }
    public void offerRide(String origin, String dest, long duration, LocalDateTime startTime, String ownerName, String vehicleName) throws NoSuchUserFoundException {
        rideService.offerRide(new Route(origin, dest), duration, startTime, ownerName, vehicleName);
    }
    public void takeRide(String name, String origin, String dest) throws NoSuchUserFoundException {
        Ride ride = rideService.bookPreferredRide(userService.getUser(name), new Route(origin, dest));
        System.out.println("Taken:");
        System.out.println(ride);
    }
    public void showOfferedRide(String userName) throws NoSuchUserFoundException {
        rideService.showOfferedRides(userService.getUser(userName));
    }
    public void showTakenRide(String takenByUser) throws NoSuchUserFoundException {
        rideService.showTakenRides(userService.getUser(takenByUser));
    }
    public void showAvailableRide(String origin, String dest){
        System.out.printf("AVAILABLE RIDES: %s->%s\n",origin,dest);
        rideService.showAllAvailableRides(new Route(origin, dest));
    }
}
