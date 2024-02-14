package splitwise.model.split;

import splitwise.model.enums.SplitType;
import splitwise.model.user.User;

public class Split {
    private SplitType type;
    private String paidTo;
    private float amount;

    public Split(SplitType type, String paidTo, float amount) {
        this.type = type;
        this.paidTo = paidTo;
        this.amount = amount;
    }

    public SplitType getType() {
        return type;
    }

    public void setType(SplitType type) {
        this.type = type;
    }

    public String getPaidTo() {
        return paidTo;
    }

    public void setPaidTo(String paidTo) {
        this.paidTo = paidTo;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
