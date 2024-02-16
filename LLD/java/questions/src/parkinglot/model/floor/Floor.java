package parkinglot.model.floor;

import parkinglot.model.config.ParkingLotConfig;
import parkinglot.model.enums.ParkingSlotStrategyType;
import parkinglot.model.enums.VehicleType;
import parkinglot.model.exceptions.NoSuchParkingSlotStrategyExistsException;
import parkinglot.model.exceptions.NoSuchSlotExistsException;
import parkinglot.model.exceptions.SlotAlreadyOccupiedException;
import parkinglot.model.parking.ParkingSlotManager;
import parkinglot.model.slot.Slot;
import parkinglot.model.vehicle.Vehicle;
import parkinglot.strategies.ConsolePrinter;
import parkinglot.strategies.NearestParkingSlotStrategy;
import parkinglot.strategies.Printer;

import java.util.HashMap;
import java.util.Map;

public class Floor {
    private Map<Integer, Slot> slotMap;
    private int floorNo;
    private int slots;
    private Printer slotPrinter;
    private ParkingSlotManager parkingSlotManager;


    public Floor(int floorNo, int slots, ParkingLotConfig config, Printer printer) throws NoSuchParkingSlotStrategyExistsException {
        this.floorNo = floorNo;
        this.slots = slots;
        this.slotMap = new HashMap<>();
        this.slotPrinter = printer;
        this.parkingSlotManager = ParkingSlotManager.getInstance(config.getParkingSlotStrategyType());
        int slotId = 0;
        for(VehicleType vehicleType: VehicleType.values()){
            int percent = config.getParkingSpacePercent(vehicleType);
            int count = percent*slots/100;
            for(int i=0;i<count;i++){
                slotMap.put(slotId, new Slot(slotId, vehicleType, floorNo));
                parkingSlotManager.addAvailableParkingSpot(vehicleType, floorNo, slotId);
                slotId+=1;
            }
        }
    }
    public int getFreeSlotsCount(VehicleType vehicleType){
        int cnt = 0;
        for(int slotId: slotMap.keySet()){
            if(!slotMap.get(slotId).isOccupied() && slotMap.get(slotId).getVehicleType().equals(vehicleType)){
                cnt++;
            }
        }
        return cnt;
    }
    public void showFreeSlots(VehicleType vehicleType){
        for(int slotId: slotMap.keySet()){
            if(!slotMap.get(slotId).isOccupied() && slotMap.get(slotId).getVehicleType().equals(vehicleType)){
                slotPrinter.print(slotMap.get(slotId));
            }
        }
        System.out.println();
    }
    public void showOccupiedSlots(VehicleType vehicleType){
        for(int slotId: slotMap.keySet()){
            if(slotMap.get(slotId).isOccupied() && slotMap.get(slotId).getVehicleType().equals(vehicleType)){
                slotPrinter.print(slotMap.get(slotId));
            }
        }
        System.out.println();
    }
    public boolean bookSlot(int slotId, Vehicle vehicle) throws NoSuchSlotExistsException, SlotAlreadyOccupiedException {
        if(!slotMap.containsKey(slotId)){
            throw new NoSuchSlotExistsException("slotId: "+slotId);
        }
        Slot slot = slotMap.get(slotId);
        if(slot.isOccupied()){
            throw new SlotAlreadyOccupiedException("slotId: "+slotId);
        }
        slot.setOccupied(true);
        slot.setOccupiedBy(vehicle);
        return true;
    }
    public boolean unBookSlot(int slotId) throws NoSuchSlotExistsException {
        if(!slotMap.containsKey(slotId)){
            throw new NoSuchSlotExistsException("slotId: "+slotId);
        }
        Slot slot = slotMap.get(slotId);
        slot.setOccupied(false);
        slot.setOccupiedBy(null);
        // update slotmanager
        parkingSlotManager.addAvailableParkingSpot(slot.getVehicleType(), this.floorNo, slotId);
        return true;
    }
}
