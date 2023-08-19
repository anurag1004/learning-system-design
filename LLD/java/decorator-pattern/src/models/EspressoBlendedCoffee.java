package models;

import interfaces.EspressoDecorator;
import interfaces.SimpleCoffee;

public class EspressoBlendedCoffee implements EspressoDecorator {
    SimpleCoffee simpleCoffee;
    private int espressoCost;
    public EspressoBlendedCoffee(SimpleCoffee simpleCoffee){
        this.simpleCoffee = simpleCoffee;
        // defaulting to 70
        this.espressoCost = 70;
    }
    @Override
    public int cost() {
        return this.simpleCoffee.cost()+this.espressoCost;
    }
    public void setEspressoCost(int espressoCost){
        this.espressoCost = espressoCost;
    }
}
