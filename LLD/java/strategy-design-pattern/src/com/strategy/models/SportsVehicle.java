package com.strategy.models;

import com.strategy.stratigies.DriveStrategy;

public class SportsVehicle implements Vehicle{
    DriveStrategy driveStrategy;
    public SportsVehicle(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }
    public void drive(){
        driveStrategy.drive();
    }
}
