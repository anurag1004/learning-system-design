package parkinglot.model.parking;

import parkinglot.model.config.ParkingLotConfig;
import parkinglot.model.enums.VehicleType;
import parkinglot.model.exceptions.NoSuchParkingSlotStrategyExistsException;
import parkinglot.model.exceptions.NoSuchSlotExistsException;
import parkinglot.model.exceptions.SlotAlreadyOccupiedException;
import parkinglot.model.exceptions.UnableToParseTicketStringException;
import parkinglot.model.floor.Floor;
import parkinglot.model.ticket.Ticket;
import parkinglot.model.ticket.TicketParser;
import parkinglot.model.vehicle.Vehicle;
import parkinglot.strategies.ConsolePrinter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private String id;
    private Map<Integer, Floor> floorMap;
    private int floors;
    private ParkingLotConfig config;
    private List<Ticket> issuedTickets;

    public ParkingLot(String id, int floors, int slotsPerFloor, ParkingLotConfig config) throws NoSuchParkingSlotStrategyExistsException {
        this.floors = floors;
        this.id = id;
        this.floorMap = new HashMap<>();
        this.config = config;
        this.issuedTickets = new ArrayList<>();
        for(int i=0;i<floors;i++){
            floorMap.put(i, new Floor(i, slotsPerFloor, config, new ConsolePrinter()));
        }
    }

    public int getFloors() {
        return floors;
    }

    public Ticket book(int floorId, int slotId, Vehicle vehicle) throws NoSuchSlotExistsException, SlotAlreadyOccupiedException {
        // try to book slot
        boolean booked = floorMap.get(floorId).bookSlot(slotId, vehicle);
        if(booked){
            Ticket ticket = new Ticket(this.id, floorId, slotId, vehicle.getType());
            issuedTickets.add(ticket);
            return ticket;
        }else{
            System.out.println("Failed to book the slot: "+slotId);
        }
        return null;
    }
    public boolean unBook(String ticketStr) throws UnableToParseTicketStringException, NoSuchSlotExistsException {
        Ticket ticket = TicketParser.parseTicket(ticketStr);
        if(floorMap.get(ticket.getFloorNo()).unBookSlot(ticket.getSlotNo())){
            System.out.printf("Unbooked the parking spot floor %d: %d \n",ticket.getFloorNo(), ticket.getSlotNo());
            return true;
        }
        System.out.println("Failed to unbook the slot: "+ticket.getSlotNo());
        return false;
    }
    public void showFreeSlotsCountPerFloor(VehicleType vehicleType){
        for(int floorId: floorMap.keySet()){
            System.out.printf("Floor %d: %d\n", floorId, floorMap.get(floorId).getFreeSlotsCount(vehicleType));
        }
    }
    public void showFreeSlotsPerFloor(VehicleType vehicleType){
        System.out.printf("----FREE SLOTS FOR %s----\n",vehicleType.toString());
        for(int floorId: floorMap.keySet()){
            System.out.println("Floor: "+floorId);
            floorMap.get(floorId).showFreeSlots(vehicleType);
        }
    }
    public void showOccupiedSlotsPerFloor(VehicleType vehicleType){
        System.out.printf("----OCCUPIED SLOTS FOR %s----\n",vehicleType.toString());
        for(int floorId: floorMap.keySet()){
            System.out.println("Floor: "+floorId);
            floorMap.get(floorId).showOccupiedSlots(vehicleType);
        }
    }
}
