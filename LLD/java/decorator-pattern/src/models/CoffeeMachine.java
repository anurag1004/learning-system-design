package models;

import interfaces.SimpleCoffee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class CoffeeMachine {
    private final String[] addOns = {
            "Latte","Espresso","Cold Brew",
            "Cappuccino"
    };
    private Map<Integer,String> addOnUserInputMap;
    private List<String> trackAddOns;

    private SimpleCoffee brew;
    public CoffeeMachine(){
        // base coffee
        brew = new SimpleBrew();
        addOnUserInputMap = new HashMap<>();
        trackAddOns = new ArrayList<>();
        // populate map
        for(int i=0;i<addOns.length;i++){
            addOnUserInputMap.put(i+1, addOns[i]);
        }
        addOnUserInputMap.put(addOns.length+1,"X"); // for exiting the coffee machine
    }
    public boolean addAddOns(Integer userInput){
        if(addOnUserInputMap.containsKey(userInput)){
            String addOn = addOnUserInputMap.get(userInput);
            if(addOn.equalsIgnoreCase("latte")){
                System.out.println("Latte added to your brew!");
                this.brew = new LatteBlendedCoffee(this.brew);
            }else if(addOn.equalsIgnoreCase("espresso")){
                System.out.println("Espresso added to your brew!");
                this.brew = new EspressoBlendedCoffee(this.brew);
            }else if(addOn.equalsIgnoreCase("Cold Brew")){
                System.out.println("Cold Brew added to your brew!");
                this.brew = new ColdBrewCoffee(this.brew);
            }else if(addOn.equalsIgnoreCase("cappuccino")){
                System.out.println("Cappuccino added to your brew!");
                this.brew = new CappuccinoBlendedCoffee(this.brew);
            }else if(addOn.equalsIgnoreCase("X")){
                System.out.println("Thank you for buying coffee with us! 🫡");
                return false;
            }
            return true;
        }else{
            System.out.println("Invalid input!");
            return false;
        }
    }
    public void showMenu(){
        // just for showing cost..not an efficient way
        int[] addOnsCost = {85,70,50,100};
        if(!trackAddOns.isEmpty()) {
            System.out.printf("Already selected addons (%d)...\n",trackAddOns.size());
            for (String addOn : trackAddOns) {
                System.out.printf("%s, ",addOn);
            }
            System.out.println();
        }else{
            System.out.printf("Simple Brew (with no addons) - Rs %d\n", brew.cost());
        }
        for(int i=0;i<addOns.length;i++){
            System.out.printf("%d.) %s - Rs %d\n", i+1, addOns[i], addOnsCost[i]);
        }
        System.out.printf("%d.) Press %d for no addons\n",addOns.length+1, addOns.length+1);
    }
    public void startApp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            this.showMenu();
            System.out.println("What addons you want in your coffee?");
            String input = br.readLine();
            boolean ok = this.addAddOns(Integer.valueOf(input));
            if(!ok){
                break;
            }
            // if addon added successfully
            this.trackAddOns.add(addOnUserInputMap.get(Integer.valueOf(input)));
            System.out.println("Want to add more? y/n");
            input = br.readLine();
            if(!input.equalsIgnoreCase("y")){
                break;
            }
        }
        System.out.println("Your brew is ready ☕!");
        System.out.printf("Amount:Rs %d\n", this.getTotalCost());
    }

    public int getTotalCost(){
        return this.brew.cost();
    }
}
