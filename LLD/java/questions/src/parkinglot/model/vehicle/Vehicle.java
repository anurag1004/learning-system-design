package parkinglot.model.vehicle;

import parkinglot.model.enums.VehicleType;

public class Vehicle {
    private String registration;
    private VehicleType type;
    private String color;

    public Vehicle(String registration, VehicleType type, String color) {
        this.registration = registration;
        this.type = type;
        this.color = color;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
