package splitwise.strategies.expense;

import splitwise.model.split.Split;

import java.util.List;

public class EqualExpenseValidator implements ExpenseValidator{

    @Override
    public boolean validate(List<Split> splits, float amount) {
        float equalSplit = amount/(float)splits.size();
        for(Split split: splits){
            if(split.getAmount()!=equalSplit){
                return false;
            }
        }
        return true;
    }
}
