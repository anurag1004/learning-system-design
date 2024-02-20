package ridesharingapp.strategy;

import ridesharingapp.model.ride.Ride;
import ridesharingapp.model.route.Route;

import java.util.List;
import java.util.Map;

public interface PreferenceStrategy {
    public Ride getPreferedRide(Route route, Map<Integer, Ride> rideMap);
}
