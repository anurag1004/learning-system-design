package com.strategy.models;


import com.strategy.stratigies.DriveStrategy;

// another way to do this
public abstract class VehicleAbstractClass{
    DriveStrategy driveStrategy;
    public VehicleAbstractClass(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }
    public void drive(){
        this.driveStrategy.drive();
    }
}
