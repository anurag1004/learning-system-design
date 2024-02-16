package parkinglot.model.config;

import parkinglot.model.enums.ParkingSlotStrategyType;
import parkinglot.model.enums.VehicleType;

import java.util.Map;

public class ParkingLotConfig {
    private Map<VehicleType, Integer> percentOfParkingSpacePerVehicleType;
    private ParkingSlotStrategyType parkingSlotStrategyType;
    public ParkingLotConfig(Map<VehicleType, Integer> map, ParkingSlotStrategyType slotStrategyType){
       if(!validator(map)){
           throw new IllegalArgumentException("total vehicleType percent should be 100!");
       }
       this.percentOfParkingSpacePerVehicleType = map;
       this.parkingSlotStrategyType = slotStrategyType;
    }

    public ParkingSlotStrategyType getParkingSlotStrategyType() {
        return parkingSlotStrategyType;
    }

    private boolean validator(Map<VehicleType, Integer> map){
        int total = 100;
        for(VehicleType vehicleType: map.keySet()){
            total-=map.get(vehicleType);
            if(total<0){
                return false;
            }
        }
        return  total==0;
    }
    public int getParkingSpacePercent(VehicleType vehicleType){
        return percentOfParkingSpacePerVehicleType.get(vehicleType);
    }
}
