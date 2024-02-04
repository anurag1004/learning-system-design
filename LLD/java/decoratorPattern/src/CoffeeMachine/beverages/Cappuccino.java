package CoffeeMachine.beverages;

public class Cappuccino implements SimpleCoffee{
    SimpleCoffee baseCoffee;
    public Cappuccino(SimpleCoffee baseCoffee){
        this.baseCoffee = baseCoffee;
    }
    @Override
    public int cost() {
        return 150 + baseCoffee.cost();
    }
}
