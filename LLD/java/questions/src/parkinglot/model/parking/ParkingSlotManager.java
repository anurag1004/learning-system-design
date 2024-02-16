package parkinglot.model.parking;

import parkinglot.model.enums.ParkingSlotStrategyType;
import parkinglot.model.enums.VehicleType;
import parkinglot.model.exceptions.NoParkingSpotLeftException;
import parkinglot.model.exceptions.NoSuchParkingSlotStrategyExistsException;
import parkinglot.model.factory.ParkingSlotStrategyFactory;
import parkinglot.strategies.ParkingSlotStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ParkingSlotManager {
    private static ParkingSlotManager parkingSlotManager;
    private Map<VehicleType, PriorityQueue<int[]>> availableSlotsMap; // vehicleType->[floorNo, slotNo]
    private ParkingSlotStrategy parkingSlotStrategy;
    private ParkingSlotManager(ParkingSlotStrategy parkingSlotStrategy){
        this.parkingSlotStrategy = parkingSlotStrategy;
    }
    public static ParkingSlotManager getInstance(ParkingSlotStrategyType parkingSlotStrategyType) throws NoSuchParkingSlotStrategyExistsException {
        if(parkingSlotManager==null){
            synchronized (ParkingSlotManager.class){
                if(parkingSlotManager==null){
                    parkingSlotManager = new ParkingSlotManager(ParkingSlotStrategyFactory.getParkingSlotStrategy(parkingSlotStrategyType));
                }
            }
        }
        return parkingSlotManager;
    }
    public int[] getNextAvailableParkingSpot(VehicleType vehicleType) throws NoParkingSpotLeftException {
        return parkingSlotStrategy.getNextAvailableParkingSpot(vehicleType);
    }
    public void removeNextAvailableParkingSpot(VehicleType vehicleType) throws NoParkingSpotLeftException {
        parkingSlotStrategy.removeNextAvailableParkingSpot(vehicleType);
    }
    public void addAvailableParkingSpot(VehicleType vehicleType, int floorNo, int slotNo){
        parkingSlotStrategy.addAvailableParkingSpot(vehicleType, floorNo, slotNo);
    }
    private boolean hasNextAvailableParkingSpot(VehicleType vehicleType){
        return parkingSlotStrategy.hasNextAvailableParkingSpot(vehicleType);
    }
}
