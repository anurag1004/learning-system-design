package parkinglot.service;

import parkinglot.model.config.ParkingLotConfig;
import parkinglot.model.enums.VehicleType;
import parkinglot.model.exceptions.*;
import parkinglot.model.parking.ParkingLot;
import parkinglot.model.parking.ParkingSlotManager;
import parkinglot.model.ticket.Ticket;
import parkinglot.model.vehicle.Vehicle;
import parkinglot.strategies.NearestParkingSlotStrategy;

import java.util.PriorityQueue;

public class ParkingLotService {
    private ParkingLot parkingLot;
    private ParkingLotConfig config;
    private ParkingSlotManager parkingSlotManager;
    public ParkingLotService(String id, int floors, int slotsPerFloor, ParkingLotConfig config) throws NoSuchParkingSlotStrategyExistsException {
        this.parkingLot = new ParkingLot(id, floors, slotsPerFloor, config);
        this.parkingSlotManager = ParkingSlotManager.getInstance(config.getParkingSlotStrategyType());
        this.config = config;
    }
    public Ticket Park(Vehicle vehicle) throws NoParkingSpotLeftException, NoSuchSlotExistsException, SlotAlreadyOccupiedException {
        int[] availableSpot = parkingSlotManager.getNextAvailableParkingSpot(vehicle.getType());
        Ticket ticket = parkingLot.book(availableSpot[0], availableSpot[1], vehicle);
        // remove the spot
        parkingSlotManager.removeNextAvailableParkingSpot(vehicle.getType());
        return ticket;
    }
    public void unPark(String ticketStr) throws NoSuchSlotExistsException, UnableToParseTicketStringException {
        parkingLot.unBook(ticketStr);
    }
    public void showFreeSlotsCountPerFloor(VehicleType vehicleType){
        this.parkingLot.showFreeSlotsCountPerFloor(vehicleType);
    }
    public void showFreeSlotsPerFloor(VehicleType vehicleType){
        this.parkingLot.showFreeSlotsPerFloor(vehicleType);
    }
    public void showOccupiedSlotsPerFloor(VehicleType vehicleType){
        this.parkingLot.showOccupiedSlotsPerFloor(vehicleType);
    }
}
