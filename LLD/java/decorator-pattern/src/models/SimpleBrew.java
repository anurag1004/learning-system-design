package models;

import interfaces.SimpleCoffee;

public class SimpleBrew implements SimpleCoffee {

    @Override
    public int cost() {
        return 100;
    }
}
