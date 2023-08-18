package com.strategy.models;

import com.strategy.stratigies.DriveStrategy;

public class OffRoadVehicle implements Vehicle{
    DriveStrategy driveStrategy;
    public OffRoadVehicle(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }
    @Override
    public void drive() {
        driveStrategy.drive();
    }
}
