package com.factorymethod.models;

import com.factorymethod.interfaces.Vehicle;
import com.factorymethod.interfaces.VehicleFactory;

public class MotorVehicleFactory implements VehicleFactory {
    @Override
    public Vehicle getVehicle(String type) {
        if(type.equalsIgnoreCase("car")){
            // do some basic config for this class
            return new Car();
        }else if(type.equalsIgnoreCase("bus")){
            return new Bus();
        }else if(type.equalsIgnoreCase("bike")){
            return new Bike();
        }
        return null;
    }
}
