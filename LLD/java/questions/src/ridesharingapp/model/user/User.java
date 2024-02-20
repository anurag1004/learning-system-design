package ridesharingapp.model.user;

import ridesharingapp.model.enums.Gender;
import ridesharingapp.model.vehicle.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private Gender gender;
    private int age;
    private Map<String, Vehicle> vehicleMap;

    public User(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicleMap = new HashMap<>();
    }
    public void addVehicle(Vehicle vehicle){
        vehicleMap.put(vehicle.getName(), vehicle);
    }
    public Vehicle getVehicle(String vehicleName){
        return vehicleMap.get(vehicleName);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
