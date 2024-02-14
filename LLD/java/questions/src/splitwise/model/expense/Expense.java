package splitwise.model.expense;

import splitwise.model.split.Split;
import splitwise.model.user.User;

import java.util.List;

public class Expense {
    private String paidBy;
    private List<Split> splits;
    private float amount;
    private ExpenseMetaData expenseMetaData;

    public ExpenseMetaData getExpenseMetaData() {
        return expenseMetaData;
    }

    public void setExpenseMetaData(ExpenseMetaData expenseMetaData) {
        this.expenseMetaData = expenseMetaData;
    }

    public Expense(String paidBy, List<Split> splits, float amount) {
        this.paidBy = paidBy;
        this.splits = splits;
        this.amount = amount;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Split s: splits){
            sb.append(String.format("paidTo: %s, amt: %.2f | ",s.getPaidTo(), s.getAmount()));
        }
        return String.format("paidBy: %s, splits: %s, total:%.2f\n",paidBy, sb.toString(), amount);
    }
}
