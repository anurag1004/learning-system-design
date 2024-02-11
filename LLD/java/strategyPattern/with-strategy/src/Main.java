public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new SportsVehicle();
        vehicle.drive();
        vehicle = new PassengerVehicle();
        vehicle.drive();
        vehicle = new OffRoadVehicle();
        vehicle.drive();
    }
}