package ATMMachine.model.card;

import ATMMachine.model.user.User;

import java.time.LocalDate;

public class Card {
    private int cardNo;
    private int cvv;
    private LocalDate expiry;
    private User holder;
    private int pin;

    public Card(int cardNo, int cvv, LocalDate expiry, User holder, int pin) {
        this.cardNo = cardNo;
        this.cvv = cvv;
        this.expiry = expiry;
        this.holder = holder;
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public int getCardNo() {
        return cardNo;
    }

    public int getCvv() {
        return cvv;
    }

    public LocalDate getExpiry() {
        return expiry;
    }

    public User getHolder() {
        return holder;
    }
}
