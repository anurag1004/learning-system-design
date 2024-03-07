package ATMMachine;

import ATMMachine.model.account.Account;
import ATMMachine.model.atm.AtmMachine;
import ATMMachine.model.bank.Bank;
import ATMMachine.model.bank.KotakBank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DriverAtmMachine {

    public static AtmMachine atmMachine;
    public static void init(){
        Bank bank = new KotakBank();
        bank.createNewAccount("user1", "u1@gmail.com", "6767678");
        bank.createNewAccount("user2", "u2@gmail.com", "4234234");
        bank.createNewAccount("user3", "u3@gmail.com", "5464564");
        atmMachine = new AtmMachine(bank);
    }
    public static void main(String[] args) {
        // init
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("READY");
        while(true){
            try {
                System.out.println("INSERT CARD (To quit, type QUIT)");
                String input = br.readLine();
                String[] parts = input.split(" ");
                if(parts[0].equalsIgnoreCase("QUIT")){
                    System.exit(0); // exit app
                }
                int cardNo = Integer.parseInt(parts[0]), pin = Integer.parseInt(parts[1]);
                atmMachine.insertCard(cardNo, pin);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
