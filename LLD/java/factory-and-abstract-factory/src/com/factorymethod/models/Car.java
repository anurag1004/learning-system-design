package com.factorymethod.models;

import com.factorymethod.interfaces.Vehicle;

public class Car implements Vehicle {
    @Override
    public void honk() {
        System.out.println("oink oink...🚗");
    }
}

