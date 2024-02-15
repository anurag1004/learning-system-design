package parkinglot.model.ticket;

import parkinglot.model.enums.VehicleType;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Ticket {
    private String parkingLotId;
    private int floorNo;
    private int slotNo;
    private VehicleType vehicleType;
    private Timestamp timestamp;

    public Ticket(String parkingLotId, int floorNo, int slotNo, VehicleType vehicleType) {
        this.parkingLotId = parkingLotId;
        this.floorNo = floorNo;
        this.slotNo = slotNo;
        this.vehicleType = vehicleType;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
    public String toString(){
        return String.format("%s_%d_%d_%s", parkingLotId, floorNo, slotNo, vehicleType.toString());
    }
    public String issueTimestamp(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(timestamp);
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
