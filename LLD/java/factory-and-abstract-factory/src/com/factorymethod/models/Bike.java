package com.factorymethod.models;

import com.factorymethod.interfaces.Vehicle;

public class Bike implements Vehicle {
    @Override
    public void honk() {
        System.out.println("Peep peep.. 🏍️");
    }
}
