package models;

import interfaces.LatteDecorator;
import interfaces.SimpleCoffee;

public class LatteBlendedCoffee implements LatteDecorator {
    SimpleCoffee simpleCoffee;
    private int latteCost;
    public LatteBlendedCoffee(SimpleCoffee simpleCoffee){
        this.simpleCoffee = simpleCoffee;
        // defaulting to 85
        this.latteCost = 85;
    }
    @Override
    public int cost() {
        return this.simpleCoffee.cost()+this.latteCost;
    }
    public void setLatteCost(int latteCost){
        this.latteCost = latteCost;
    }
}
