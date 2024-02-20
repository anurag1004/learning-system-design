package ridesharingapp.model.vehicle;

import ridesharingapp.model.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Vehicle {
    private final String name;
    private final String regNo;
    private final User owner;
    private int seats;
    private List<User> passenger;

    public Vehicle(String name, String regNo, User owner, int seats) {
        this.name = name;
        this.regNo = regNo;
        this.owner = owner;
        this.seats = seats-1;
        this.passenger = new ArrayList<>(Collections.singletonList(owner));
    }

    public String getName() {
        return name;
    }

    public String getRegNo() {
        return regNo;
    }

    public User getOwner() {
        return owner;
    }

    public int getSeats() {
        return seats;
    }

    public List<User> getPassenger() {
        return passenger;
    }
    public void addPassenger(User user){
        this.passenger.add(user);
    }
    public boolean isSeatsAvailable(){
        return this.seats>0;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
