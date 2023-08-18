package com.nonstrategy.models;

public class PassangerVehicle implements Vehicle{

    @Override
    public void drive() {
        System.out.println("Passenger vehicle driving..");
    }
}
