package parkinglot.model.parking;

import java.util.Comparator;

public class ParkingSlotComparator implements Comparator<int[]> {
    public int compare(int[] s1, int[] s2){
        if(s1[0]==s2[0]){ // if same floor
            return s1[1]-s2[1];
        }
        return s1[0]-s2[0];
    }
}
