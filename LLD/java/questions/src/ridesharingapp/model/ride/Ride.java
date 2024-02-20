package ridesharingapp.model.ride;

import ridesharingapp.model.route.Route;
import ridesharingapp.model.vehicle.Vehicle;

import java.time.LocalDateTime;

public class Ride {
    private static int count;
    private final int rideId;
    private final Route route;
    private final long duration; // in hrs
    private final LocalDateTime startTime;
    private final Vehicle vehicle;

    public Ride(Route route, long duration, LocalDateTime startTime, Vehicle vehicle) {
        this.route = route;
        this.duration = duration;
        this.startTime = startTime;
        this.vehicle = vehicle;
        this.rideId = ++count;
    }

    public Route getRoute() {
        return route;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public long getDuration() {
        return duration;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
    public String toString(){
        return String.format("RideId: %d, Duration: %d hrs, start: %s, driver: %s",rideId,duration,startTime.toString(),vehicle.getOwner().getName());
    }

    public int getRideId() {
        return rideId;
    }
}
