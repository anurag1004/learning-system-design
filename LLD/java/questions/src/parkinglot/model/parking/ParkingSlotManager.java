package parkinglot.model.parking;

import parkinglot.model.enums.VehicleType;
import parkinglot.model.exceptions.NoParkingSpotLeftException;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ParkingSlotManager {
    private static ParkingSlotManager parkingSlotManager;
    private Map<VehicleType, PriorityQueue<int[]>> availableSlotsMap; // vehicleType->[floorNo, slotNo]
    private ParkingSlotManager(){
        availableSlotsMap = new HashMap<>();
        for(VehicleType vehicleType: VehicleType.values()){
            availableSlotsMap.put(vehicleType, new PriorityQueue<>(new ParkingSlotComparator()));
        }
    }
    public static ParkingSlotManager getInstance(){
        if(parkingSlotManager==null){
            synchronized (ParkingSlotManager.class){
                if(parkingSlotManager==null){
                    parkingSlotManager = new ParkingSlotManager();
                }
            }
        }
        return parkingSlotManager;
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
    private boolean hasNextAvailableParkingSpot(VehicleType vehicleType){
        return !availableSlotsMap.get(vehicleType).isEmpty();
    }
}
