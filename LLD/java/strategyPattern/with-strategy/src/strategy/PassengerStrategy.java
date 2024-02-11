package strategy;

public class PassengerStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("passenger drive");
    }
}
