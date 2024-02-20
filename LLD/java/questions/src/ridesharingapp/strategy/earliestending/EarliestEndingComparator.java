package ridesharingapp.strategy.earliestending;

import ridesharingapp.model.ride.Ride;

import java.time.LocalDateTime;
import java.util.Comparator;

public class EarliestEndingComparator implements Comparator<Ride> {
    public int compare(Ride r1, Ride r2){
        LocalDateTime end1 = r1.getStartTime().plusHours(r1.getDuration());
        LocalDateTime end2 = r2.getStartTime().plusHours(r2.getDuration());
        return end1.compareTo(end2);
    }
}
