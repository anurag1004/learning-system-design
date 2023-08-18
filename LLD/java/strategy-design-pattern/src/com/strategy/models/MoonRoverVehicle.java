package com.strategy.models;

import com.strategy.stratigies.DriveStrategy;
import com.strategy.stratigies.SlowAndSmartDriveStrategy;

public class MoonRoverVehicle extends VehicleAbstractClass{
    public MoonRoverVehicle() {
        super(new SlowAndSmartDriveStrategy());
    }
}
