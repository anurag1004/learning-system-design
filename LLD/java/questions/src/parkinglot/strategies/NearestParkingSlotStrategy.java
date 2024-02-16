package parkinglot.strategies;

import parkinglot.model.enums.VehicleType;
import parkinglot.model.exceptions.NoParkingSpotLeftException;
import parkinglot.model.parking.ParkingSlotComparator;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NearestParkingSlotStrategy implements ParkingSlotStrategy{
    private Map<VehicleType, PriorityQueue<int[]>> availableSlotsMap; // vehicleType->[floorNo, slotNo]
    public NearestParkingSlotStrategy(){
        availableSlotsMap = new HashMap<>();
        for(VehicleType vehicleType: VehicleType.values()){
            availableSlotsMap.put(vehicleType, new PriorityQueue<>(new ParkingSlotComparator()));
        }
    }
    public int[] getNextAvailableParkingSpot(VehicleType vehicleType) throws NoParkingSpotLeftException {
        if(!hasNextAvailableParkingSpot(vehicleType)){
            throw new NoParkingSpotLeftException("vehicleType: "+vehicleType.toString());
        }
        return availableSlotsMap.get(vehicleType).peek();
    }
    public void removeNextAvailableParkingSpot(VehicleType vehicleType) throws NoParkingSpotLeftException {
        if (!hasNextAvailableParkingSpot(vehicleType)) {
            throw new NoParkingSpotLeftException("vehicleType: " + vehicleType.toString());
        }
        availableSlotsMap.get(vehicleType).poll();
    }
    public void addAvailableParkingSpot(VehicleType vehicleType, int floorNo, int slotNo){
        availableSlotsMap.get(vehicleType).add(new int[]{floorNo, slotNo});
    }
    public boolean hasNextAvailableParkingSpot(VehicleType vehicleType){
        return !availableSlotsMap.get(vehicleType).isEmpty();
    }
}
