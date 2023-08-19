package models;

import interfaces.CappuccinoDecorator;
import interfaces.SimpleCoffee;

public class CappuccinoBlendedCoffee implements CappuccinoDecorator {
    SimpleCoffee simpleCoffee;
    private int cappuccinoCost;
    public CappuccinoBlendedCoffee(SimpleCoffee simpleCoffee){
        this.simpleCoffee = simpleCoffee;
        // defaulting to 100
        this.cappuccinoCost = 100;
    }
    @Override
    public int cost() {
        return this.simpleCoffee.cost()+this.cappuccinoCost;
    }
    public void setCappuccinoCost(int cappuccinoCost){
        this.cappuccinoCost = cappuccinoCost;
    }
}
