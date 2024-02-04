package CoffeeMachine;

import CoffeeMachine.beverages.BaseCoffee;
import CoffeeMachine.beverages.Cappuccino;
import CoffeeMachine.beverages.Decaf;

public class CoffeeMachine {
    public static void main(String[] args) {
        System.out.println(new Decaf(new Decaf(new Cappuccino(new BaseCoffee()))).cost());
    }
}