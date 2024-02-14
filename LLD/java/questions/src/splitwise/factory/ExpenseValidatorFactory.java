package splitwise.factory;

import splitwise.exceptions.InvalidSplitTypeException;
import splitwise.model.enums.SplitType;
import splitwise.strategies.expense.EqualExpenseValidator;
import splitwise.strategies.expense.ExactExpenseValidator;
import splitwise.strategies.expense.ExpenseValidator;
import splitwise.strategies.expense.PercentExpenseValidator;

public class ExpenseValidatorFactory {
    public static ExpenseValidator getExpenseValidator(SplitType splitType) throws InvalidSplitTypeException {
        return switch (splitType) {
            case EQUAL -> new EqualExpenseValidator();
            case EXACT, SHARE -> new ExactExpenseValidator();
            case PERCENT -> new PercentExpenseValidator();
            default -> throw new InvalidSplitTypeException("Unsupported split-type: " + splitType);
        };
    }
}
