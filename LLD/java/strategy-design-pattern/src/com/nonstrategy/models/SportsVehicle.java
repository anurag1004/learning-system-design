package com.nonstrategy.models;

public class SportsVehicle implements Vehicle{
    @Override
    public void drive(){ // this drive strategy or algorithm is same as OffRoadVehicle.
        System.out.println("Speed and High traction drive..");
    }
}
