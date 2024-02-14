package splitwise.strategies.expense;

import splitwise.model.split.Split;

import java.util.List;

public interface ExpenseValidator {
    public boolean validate(List<Split> splits, float amount);
}
