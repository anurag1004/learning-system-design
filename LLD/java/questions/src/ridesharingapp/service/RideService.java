package ridesharingapp.service;

import ridesharingapp.model.enums.RideType;
import ridesharingapp.model.exceptions.NoSuchUserFoundException;
import ridesharingapp.model.ride.Ride;
import ridesharingapp.model.route.Route;
import ridesharingapp.model.user.User;
import ridesharingapp.model.vehicle.Vehicle;
import ridesharingapp.repository.UserRepository;
import ridesharingapp.strategy.PreferenceStrategy;

import java.time.LocalDateTime;
import java.util.*;

public class RideService {
    private PreferenceStrategy preferenceStrategy;
    private Map<Integer, Ride> availableRides;
    private Map<RideType, Map<String, List<Ride>>> offeredAndTakenRides;
    private UserService userService;

    public RideService(PreferenceStrategy preferenceStrategy) {
        this.preferenceStrategy = preferenceStrategy;
        this.offeredAndTakenRides =  new HashMap<>();
        this.availableRides = new HashMap<>();
        this.userService = new UserService();
    }
    public void showAllAvailableRides(Route route){
        for(Integer rideId: availableRides.keySet()){
            Ride ride = availableRides.get(rideId);
            if(ride.getRoute().getOrigin().equalsIgnoreCase(route.getOrigin()) && ride.getRoute().getDest().equalsIgnoreCase(route.getDest())){
                System.out.println(availableRides.get(rideId));
            }
        }
    }
    public Ride bookPreferredRide(User bookBy, Route route){
        Ride ride = preferenceStrategy.getPreferedRide(route, availableRides);
        updateOfferedAndTakenRides(ride, RideType.TAKEN, null, bookBy);
        ride.getVehicle().setSeats(ride.getVehicle().getSeats()-1);
        ride.getVehicle().addPassenger(bookBy);
        if(ride.getVehicle().getSeats()==0){
            availableRides.remove(ride.getRideId());
        }
        return ride;
    }
    public void offerRide(Route route, long duration, LocalDateTime startTime, String ownerName, String vehicleName) throws NoSuchUserFoundException {
        User owner  = userService.getUser(ownerName);
        Ride newRide = new Ride(route, duration, startTime, owner.getVehicle(vehicleName));
        availableRides.put(newRide.getRideId(), newRide);
        updateOfferedAndTakenRides(newRide, RideType.OFFERING, owner, null);
    }
    public void showOfferedRides(User owner){
        System.out.println("Rides offered by:"+owner.getName());
        for(Ride ride: offeredAndTakenRides.get(RideType.OFFERING).get(owner.getName())){
            System.out.println(ride);
        }
    }
    public void showTakenRides(User takenBy){
        System.out.println("Rides taken by:"+takenBy.getName());
        for(Ride ride: offeredAndTakenRides.get(RideType.TAKEN).get(takenBy.getName())){
            System.out.println(ride);
        }
    }
    public void updateOfferedAndTakenRides(Ride ride, RideType rideType, User owner, User takenBy){
        if(rideType.equals(RideType.OFFERING)) {
            offeredAndTakenRides.putIfAbsent(RideType.OFFERING, new HashMap<>());
            offeredAndTakenRides.get(RideType.OFFERING).putIfAbsent(owner.getName(), new ArrayList<>());
            offeredAndTakenRides.get(RideType.OFFERING).get(owner.getName()).add(ride);
        }else{
            offeredAndTakenRides.putIfAbsent(RideType.TAKEN, new HashMap<>());
            offeredAndTakenRides.get(RideType.TAKEN).putIfAbsent(takenBy.getName(), new ArrayList<>());
            offeredAndTakenRides.get(RideType.TAKEN).get(takenBy.getName()).add(ride);
        }
    }
}
