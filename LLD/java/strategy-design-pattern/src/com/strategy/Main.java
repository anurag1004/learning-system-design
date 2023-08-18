package com.strategy;

import com.strategy.models.*;
import com.strategy.stratigies.PassengerDriveStrategy;
import com.strategy.stratigies.SpeedAndTractionDriveStrategy;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new PassengerVehicle(new PassengerDriveStrategy());
        vehicle.drive();

        vehicle = new OffRoadVehicle(new SpeedAndTractionDriveStrategy());
        vehicle.drive();

        vehicle = new SportsVehicle(new SpeedAndTractionDriveStrategy());
        vehicle.drive();

        // using abstract class
        VehicleAbstractClass vehicleAbstractClass = new MoonRoverVehicle();
        vehicleAbstractClass.drive();

    }
}
