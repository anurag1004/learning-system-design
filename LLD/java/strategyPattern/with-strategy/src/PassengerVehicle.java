import strategy.PassengerStrategy;

public class PassengerVehicle extends Vehicle{
    public PassengerVehicle(){
        super(new PassengerStrategy());
    }
}
