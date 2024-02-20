package ridesharingapp.strategy.earliestending;

import ridesharingapp.model.ride.Ride;
import ridesharingapp.model.route.Route;
import ridesharingapp.strategy.PreferenceStrategy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class EarliestEndingPreferenceStrategy implements PreferenceStrategy {

    public EarliestEndingPreferenceStrategy(){
    }
    @Override
    public Ride getPreferedRide(Route route, Map<Integer, Ride> rideMap) {
        Ride ans = null;
        LocalDateTime earliestEnding = null;
        for(int rideId: rideMap.keySet()){
            Ride ride = rideMap.get(rideId);
            if(ride.getRoute().getOrigin().equalsIgnoreCase(route.getOrigin()) && ride.getRoute().getDest().equalsIgnoreCase(route.getDest())){
                if(earliestEnding==null || earliestEnding.isAfter(ride.getStartTime().plusHours(ride.getDuration()))){
                    earliestEnding = ride.getStartTime().plusHours(ride.getDuration());
                    ans = ride;
                }
            }
        }
        return ans;
    }
}
