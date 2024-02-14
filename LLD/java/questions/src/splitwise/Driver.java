package splitwise;

import splitwise.exceptions.InvalidCommandException;
import splitwise.exceptions.InvalidInputExpenseException;
import splitwise.exceptions.InvalidSplitTypeException;
import splitwise.exceptions.NoSuchUserExistsException;
import splitwise.model.enums.Command;
import splitwise.model.enums.SplitType;
import splitwise.model.split.Split;
import splitwise.model.user.User;
import splitwise.orchestrator.ExpenseManager;
import splitwise.strategies.printer.ConsolePrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {
    private static ExpenseManager expenseManager;
    public static void init(){
        User u1 = new User("u1","u1@gmail.com","78822342");
        User u2 = new User("u2","u2@gmail.com","34432424");
        User u3 = new User("u3","u3@gmail.com","23442344");
        User u4 = new User("u4","u4@gmail.com","92423457");
        expenseManager = new ExpenseManager(new ConsolePrinter());
        expenseManager.addUsers(List.of(u1,u2,u3,u4));
    }
    public static void main(String[] args) {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        Expense in the format: EXPENSE <user-id-of-person-who-paid> <amount-paid> <no-of-users> <space-separated-list-of-users> <EQUAL/EXACT/PERCENT> <space-separated-values-in-case-of-non-equal>

        Show balances for all: SHOW

        Show balances for a single user: SHOW <user-id>
        */
        while(true){
            try{
                String input = br.readLine();
                String[] parts = input.split(" ");
                String command = parts[0];
                if(command.equalsIgnoreCase(Command.SHOW.toString())) {
                    String userId = parts.length > 1 ? parts[1] : "";
                    expenseManager.showBalances(userId);
                }else if(command.equalsIgnoreCase(Command.EXPENSE.toString())){
                    String paidBy = parts[1];
                    float amountPaid = Float.parseFloat(parts[2]);
                    int numUsers = Integer.parseInt(parts[3]);
                    List<String> userIds = new ArrayList<>();
                    int i = 4;
                    while(i<4+numUsers && i< parts.length){
                        userIds.add(parts[i++]);
                    }
                    if(userIds.size()!=numUsers){
                        System.out.println("Count of userId provided don't match!");
                        continue;
                    }
                    SplitType splitType = null;
                    try{
                        splitType = SplitType.valueOf(parts[i++]);
                    }catch (IllegalArgumentException e){
                        System.out.println("Invalid split-type input provided!");
                        continue;
                    }catch (Exception exp){
                        throw exp;
                    }
                    List<Split> splits = new ArrayList<>();
                    List<Float> amounts = new ArrayList<>();
                    switch (splitType){
                        case EQUAL:
                            for(String userId: userIds){
                                splits.add(new Split(splitType, userId, amountPaid/(float)numUsers));
                            }
                            expenseManager.addExpense(splitType, amountPaid, paidBy, splits);
                            break;
                        case EXACT:
                            while(i<parts.length){
                                amounts.add(Float.parseFloat(parts[i]));
                                i++;
                            }
                            for(int j=0;j<numUsers;j++){
                                splits.add(new Split(splitType, userIds.get(j), amounts.get(j)));
                            }
                            expenseManager.addExpense(splitType, amountPaid, paidBy, splits);
                            break;
                        case SHARE:
                            int totalShares = 0;
                            List<Integer> shares = new ArrayList<>();
                            while(i<parts.length){
                                totalShares += Integer.parseInt(parts[i]);
                                shares.add(Integer.parseInt(parts[i++]));
                            }
                            for(int j=0;j<numUsers;j++){
                                float amount = ((float)shares.get(j)*amountPaid)/(float)totalShares;
                                splits.add(new Split(splitType, userIds.get(j), amount));
                            }
                            expenseManager.addExpense(splitType, amountPaid, paidBy, splits);
                            break;
                        case PERCENT:
                            while(i<parts.length){
                                amounts.add((Float.parseFloat(parts[i])/100f)*amountPaid);
                                i++;
                            }
                            for(int j=0;j<numUsers;j++){
                                splits.add(new Split(splitType, userIds.get(j), amounts.get(j)));
                            }
                            expenseManager.addExpense(splitType, amountPaid, paidBy, splits);
                    }
                }else if(command.equalsIgnoreCase(Command.EXIT.toString())){
                    System.exit(0);
                }else{
                    throw new InvalidCommandException("invalid command entered: "+command);
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }
}
// e 1 3 2 3 4
