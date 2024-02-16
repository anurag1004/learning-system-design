package parkinglot;

import parkinglot.model.config.ParkingLotConfig;
import parkinglot.model.enums.Command;
import parkinglot.model.enums.DisplayType;
import parkinglot.model.enums.ParkingSlotStrategyType;
import parkinglot.model.enums.VehicleType;
import parkinglot.model.exceptions.NoSuchDisplayCommandException;
import parkinglot.model.exceptions.NoSuchParkingSlotStrategyExistsException;
import parkinglot.model.ticket.Ticket;
import parkinglot.model.vehicle.Vehicle;
import parkinglot.service.ParkingLotService;
import splitwise.exceptions.InvalidCommandException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* • create_parking_lot <parking_lot_id> <no_of_floors> <no_of_slots_per_floor>
• park_vehicle <vehicle_type> <reg_no> <color>
• unpark_vehicle <ticket_id>
• display <display_type> <vehicle_type>
	Possible values of display_type: free_count, free_slots, occupied_slots
exit
*
* */
public class Driver {
    public static ParkingLotConfig getAppConfig(){
        Map<VehicleType, Integer> configMap = new HashMap<>();
        List<Integer> percents = List.of(60,40);
        int i = 0;
        for(VehicleType vehicleType: VehicleType.values()){
            configMap.put(vehicleType, percents.get(i));
            i++;
        }
        return new ParkingLotConfig(configMap, ParkingSlotStrategyType.NEAREST_PARKING_SLOT);
    }
    public static void main(String[] args) throws IOException, InvalidCommandException, NoSuchParkingSlotStrategyExistsException {
        ParkingLotService parkingLotService;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter command to create parking lot:\n create_parking_lot <parking_lot_id> <no_of_floors> <no_of_slots_per_floor> \n");
        String input = br.readLine();
        String[] parts = input.split(" ");
        Command cmd = Command.valueOf(parts[0]);
        if(!cmd.equals(Command.CREATE_PARKING_LOT)){
            throw new InvalidCommandException("invalid command: "+cmd);
        }
        String id = parts[1];
        int floors = Integer.parseInt(parts[2]);
        int slots = Integer.parseInt(parts[3]);
        parkingLotService = new ParkingLotService(id, floors, slots, getAppConfig());
        System.out.println("Initialization complete...");
        Ticket ticket = null;
        while(true){
            try {
                input = br.readLine();
                parts = input.split(" ");
                cmd = Command.valueOf(parts[0]);
                switch (cmd){
                    case PARK :
                        VehicleType vehicleType = VehicleType.valueOf(parts[1]);
                        String regNo = parts[2];
                        String color = parts[3];
                        ticket =parkingLotService.Park(new Vehicle(regNo, vehicleType, color));
                        System.out.println("Parking ticket: "+ticket);
                        break;
                    case UNPARK:
                        String ticketStr = parts[1];
                        parkingLotService.unPark(ticketStr);
                        break;
                    case DISPLAY:
                        DisplayType displayType = DisplayType.valueOf(parts[1]);
                        VehicleType vehicleType1 = VehicleType.valueOf(parts[2]);
                        switch (displayType){
                            case FREE_COUNT:
                                parkingLotService.showFreeSlotsCountPerFloor(vehicleType1);
                                break;
                            case FREE_SLOTS:
                                parkingLotService.showFreeSlotsPerFloor(vehicleType1);
                                break;
                            case OCCUPIED_SLOTS:
                                parkingLotService.showOccupiedSlotsPerFloor(vehicleType1);
                                break;
                            default:
                                throw new NoSuchDisplayCommandException("invalid display cmd: "+displayType.toString());
                        }
                    case EXIT:
                        System.exit(0);
                }
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }
}
