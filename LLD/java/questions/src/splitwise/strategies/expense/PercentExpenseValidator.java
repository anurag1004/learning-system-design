package splitwise.strategies.expense;

import splitwise.model.split.Split;

import java.util.List;

public class PercentExpenseValidator implements ExpenseValidator{
    @Override
    public boolean validate(List<Split> splits, float amount) {
        float validateAmount = 0f;
        for(Split split: splits){
            validateAmount+=split.getAmount();
        }
        return validateAmount==amount;
    }
}
