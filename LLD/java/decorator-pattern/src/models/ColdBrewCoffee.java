package models;

import interfaces.ColdBrewDecorator;
import interfaces.SimpleCoffee;

public class ColdBrewCoffee implements ColdBrewDecorator {
    SimpleCoffee simpleCoffee;
    private int coldBrewCost;
    public ColdBrewCoffee(SimpleCoffee simpleCoffee){
        this.simpleCoffee = simpleCoffee;
        // defaulting to 50
        this.coldBrewCost = 50;
    }
    @Override
    public int cost() {
        return this.simpleCoffee.cost()+this.coldBrewCost;
    }
    public void setColdBrewCost(int coldBrewCost){
        this.coldBrewCost = coldBrewCost;
    }
}
