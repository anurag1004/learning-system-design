package ATMMachine.model.account;

import ATMMachine.model.card.Card;
import ATMMachine.model.exceptions.NoBalanceException;
import ATMMachine.model.user.User;

public class Account {
    private User user;
    private int acNo;
    private Card linkedCard;
    private int balance;

    public Account(int acNo,User user) {
        this.acNo = acNo;
        this.user = user;
        this.balance = 0;
    }

    public void setLinkedCard(Card linkedCard) {
        this.linkedCard = linkedCard;
    }

    public int withdraw(int amt) throws NoBalanceException {
        if(amt > balance){
            throw new NoBalanceException("No balance!");
        }
        balance-=amt;
        return balance; // return new balance
    }
    public int deposit(int amt){
        balance+=amt;
        return balance;
    }

    public int getBalance() {
        return balance;
    }

    public Card getLinkedCard() {
        return linkedCard;
    }

    public User getUser() {
        return user;
    }
}
