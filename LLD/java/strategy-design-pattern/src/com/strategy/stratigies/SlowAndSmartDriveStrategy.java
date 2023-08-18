package com.strategy.stratigies;

public class SlowAndSmartDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Slow and Smart drive strategy...");
    }
}
