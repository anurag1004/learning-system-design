package parkinglot.model.slot;

import parkinglot.model.enums.VehicleType;
import parkinglot.model.vehicle.Vehicle;

public class Slot {
    private int id;
    private VehicleType vehicleType;
    private int floorNo;
    private boolean isOccupied;
    private Vehicle occupiedBy;

    public Slot(int id, VehicleType vehicleType, int floorNo) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.floorNo = floorNo;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Vehicle getOccupiedBy() {
        return occupiedBy;
    }

    public void setOccupiedBy(Vehicle occupiedBy) {
        this.occupiedBy = occupiedBy;
    }
}
