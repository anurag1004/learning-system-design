package strategy;

public class SportsStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("sports strategy");
    }
}
