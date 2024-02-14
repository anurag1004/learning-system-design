package splitwise.service;

import splitwise.exceptions.InvalidInputExpenseException;
import splitwise.exceptions.InvalidSplitTypeException;
import splitwise.factory.ExpenseValidatorFactory;
import splitwise.model.enums.SplitType;
import splitwise.model.expense.Expense;
import splitwise.model.split.Split;
import splitwise.model.user.User;
import splitwise.strategies.expense.ExpenseValidator;

import java.util.List;

public class ExpenseService {

    public static Expense createExpense(SplitType splitType, float amount, String paidBy, List<Split> splits) throws InvalidSplitTypeException, InvalidInputExpenseException {
        ExpenseValidator validator = ExpenseValidatorFactory.getExpenseValidator(splitType);
        if(validator.validate(splits, amount)){
            return new Expense(paidBy, splits, amount);
        }else {
            throw new InvalidInputExpenseException("expense validation failed");
        }
    }
}
