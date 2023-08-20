package com.factorymethod;

import com.factorymethod.interfaces.Vehicle;
import com.factorymethod.models.Car;
import com.factorymethod.models.MotorVehicleFactory;

public class Main {
    public static void main(String[] args) {
        MotorVehicleFactory motorVehicleFactory = new MotorVehicleFactory();
        motorVehicleFactory.getVehicle("car").honk();
        motorVehicleFactory.getVehicle("bus").honk();
        motorVehicleFactory.getVehicle("bike").honk();
    }
}
