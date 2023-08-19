import models.CoffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
       CoffeeMachine coffeeMachine = new CoffeeMachine();
       System.out.println("Starting coffee machine....");
       coffeeMachine.startApp();
    }
}
