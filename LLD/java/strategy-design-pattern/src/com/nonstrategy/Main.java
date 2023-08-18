package com.nonstrategy;

import com.nonstrategy.models.OffRoadvehicle;
import com.nonstrategy.models.PassangerVehicle;
import com.nonstrategy.models.SportsVehicle;
import com.nonstrategy.models.Vehicle;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new OffRoadvehicle();
        vehicle.drive();
        vehicle = new SportsVehicle();
        vehicle.drive();
        vehicle = new PassangerVehicle();
        vehicle.drive();
    }
}
