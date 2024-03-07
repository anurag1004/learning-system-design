package ATMMachine.model.atm;

import ATMMachine.model.account.Account;
import ATMMachine.model.bank.Bank;
import ATMMachine.model.card.Card;
import ATMMachine.model.enums.CMDS;
import ATMMachine.model.exceptions.IncorrectPinException;
import ATMMachine.model.exceptions.NoSuchCardExistException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AtmMachine {
    private Bank bank;
    public AtmMachine(Bank bank){
        this.bank = bank;
    }
    public void insertCard(int cardNo, int pin) throws NoSuchCardExistException, IncorrectPinException {
        Account account = bank.getAcLinkedWithCard(cardNo);
        Card card = account.getLinkedCard();
        if(card.getPin()==pin){
            System.out.println("********* "+ bank.getBankName()+" *********");
            System.out.println("WELCOME : "+account.getUser().getName()+" :-)");
            // show options to withdraw/deposit
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            boolean isRunning = true;
            while(isRunning){
                try {
                    System.out.println("WITHDRAW \nDEPOSIT \nSHOW_BALANCE \nEXIT_USER\n");
                    String input = br.readLine();
                    CMDS inputCmd = CMDS.valueOf(input);
                    switch (inputCmd){
                        case DEPOSIT:
                            System.out.println("Enter amount to be deposited: ");
                            String depositAmtInput = br.readLine();
                            int depositAmt = Integer.parseInt(depositAmtInput);
                            System.out.println("Amount deposited!\nNew balance: "+account.deposit(depositAmt));
                            break;
                        case WITHDRAW:
                            System.out.println("Enter amount to be withdrawn: ");
                            String withdrawAmtInput = br.readLine();
                            int withdrawAmt = Integer.parseInt(withdrawAmtInput);
                            System.out.println("Amount withdrawn!\nCash: "+account.withdraw(withdrawAmt));
                            break;
                        case SHOW_BALANCE:
                            System.out.println("Balance: "+account.getBalance());
                            break;
                        case EXIT_USER:
                            isRunning = false;
                            break;
                        default:
                            System.out.println("Invalid cmd entered");
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
//                    e.printStackTrace();
                }
            }
        }else{
            throw new IncorrectPinException("Incorrect Pin entered!");
        }
        System.out.println("Card removed: "+cardNo);
    }
}
