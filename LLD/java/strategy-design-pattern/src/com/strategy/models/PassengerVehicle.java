package com.strategy.models;

import com.strategy.stratigies.DriveStrategy;

public class PassengerVehicle implements Vehicle{
    DriveStrategy driveStrategy;
    public PassengerVehicle(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }
    public void drive(){
        driveStrategy.drive();
    }
}
