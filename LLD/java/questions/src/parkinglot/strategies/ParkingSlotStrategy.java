package parkinglot.strategies;

import parkinglot.model.enums.VehicleType;
import parkinglot.model.exceptions.NoParkingSpotLeftException;

public interface ParkingSlotStrategy {
    public int[] getNextAvailableParkingSpot(VehicleType vehicleType) throws NoParkingSpotLeftException;
    public void removeNextAvailableParkingSpot(VehicleType vehicleType) throws NoParkingSpotLeftException;
    public void addAvailableParkingSpot(VehicleType vehicleType, int floorNo, int slotNo);
    public boolean hasNextAvailableParkingSpot(VehicleType vehicleType);
}
