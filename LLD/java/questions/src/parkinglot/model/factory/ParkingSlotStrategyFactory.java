package parkinglot.model.factory;

import parkinglot.model.enums.ParkingSlotStrategyType;
import parkinglot.model.exceptions.NoSuchParkingSlotStrategyExistsException;
import parkinglot.strategies.NearestParkingSlotStrategy;
import parkinglot.strategies.ParkingSlotStrategy;

import java.util.HashMap;
import java.util.Map;

public class ParkingSlotStrategyFactory {
    private static Map<ParkingSlotStrategyType, ParkingSlotStrategy> cache = new HashMap<>();
    public static ParkingSlotStrategy getParkingSlotStrategy(ParkingSlotStrategyType type) throws NoSuchParkingSlotStrategyExistsException {
        switch (type){
            case NEAREST_PARKING_SLOT:
                if(cache.containsKey(type)){
                    return cache.get(type);
                }
                ParkingSlotStrategy strategy = new NearestParkingSlotStrategy();
                cache.put(type, strategy);
                return strategy;
            default:
                throw new NoSuchParkingSlotStrategyExistsException("no such parking slot strategy exists: "+type.toString());
        }
    }
}
