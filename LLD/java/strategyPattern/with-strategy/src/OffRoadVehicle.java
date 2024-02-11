import strategy.SportsStrategy;

public class OffRoadVehicle extends Vehicle{
    public OffRoadVehicle(){
        super(new SportsStrategy());
    }
}
