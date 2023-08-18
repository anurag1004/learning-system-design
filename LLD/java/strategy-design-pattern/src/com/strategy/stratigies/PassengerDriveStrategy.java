package com.strategy.stratigies;

public class PassengerDriveStrategy implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println("Passenger vehicle driving..");
    }
}
