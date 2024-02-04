package CoffeeMachine.beverages;

public class Decaf implements SimpleCoffee{
    SimpleCoffee baseCoffee;
    public Decaf(SimpleCoffee baseCoffee){
        this.baseCoffee = baseCoffee;
    }
    @Override
    public int cost() {
        return 100 + baseCoffee.cost();
    }
}
