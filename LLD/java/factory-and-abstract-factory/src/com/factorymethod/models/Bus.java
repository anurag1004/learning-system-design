package com.factorymethod.models;

import com.factorymethod.interfaces.Vehicle;

public class Bus implements Vehicle {

    @Override
    public void honk() {
        System.out.println("Booop Boop....🚌");
    }
}
