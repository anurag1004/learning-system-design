import strategy.SportsStrategy;

public class SportsVehicle extends  Vehicle{
    public SportsVehicle(){
        super(new SportsStrategy());
    }
}
