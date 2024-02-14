package splitwise.orchestrator;

import splitwise.exceptions.InvalidInputExpenseException;
import splitwise.exceptions.InvalidSplitTypeException;
import splitwise.exceptions.NoSuchUserExistsException;
import splitwise.model.enums.SplitType;
import splitwise.model.expense.Expense;
import splitwise.model.split.Split;
import splitwise.model.user.User;
import splitwise.service.ExpenseService;
import splitwise.strategies.printer.BalancePrinter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    private List<Expense> expenseList;
    private Map<String, User> userMap;
    private Map<String, Map<String, Float>> balanceSheet;
    private BalancePrinter printer;

    public ExpenseManager(BalancePrinter printer){
        this.expenseList = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.balanceSheet = new HashMap<>();
        this.printer = printer;
    }
    public void addExpense(SplitType splitType, float amount, String paidBy, List<Split> splits) throws InvalidInputExpenseException, InvalidSplitTypeException, NoSuchUserExistsException {
        if(!userMap.containsKey(paidBy)){
            throw new NoSuchUserExistsException(String.format("%s don't exists!", paidBy));
        }
        Expense expense = ExpenseService.createExpense(splitType, amount, paidBy, splits);
//        System.out.println(expense);
        expenseList.add(expense); // add expense to expense list
        // update balance sheet
        for(Split split: splits){
            Map<String, Float> balances = balanceSheet.get(paidBy);
            // update balancesheet for payer
            String paidTo = split.getPaidTo();
            balances.putIfAbsent(paidTo, 0f);
            balances.put(paidTo, balances.get(paidTo) + split.getAmount());
            // update balancesheet for payee
            balances = balanceSheet.get(paidTo);
            balances.putIfAbsent(paidBy, 0f);
            balances.put(paidBy, balances.get(paidBy) - split.getAmount());
        }
    }
    public void showBalances(String userId){
        printer.print(balanceSheet, userId);
    }
    public void addUsers(List<User> users){
        for(User user: users){
            addUser(user);
        }
    }
    public void addUser(User user){
        userMap.put(user.getName(), user);
        balanceSheet.put(user.getName(), new HashMap<>());
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }
}













