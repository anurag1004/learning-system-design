package ATMMachine.model.user;

import ATMMachine.model.card.Card;

public class User {
    private String name;
    private String email;
    private String phnNum;
    private Card card;

    public User(String name, String email, String phnNum) {
        this.name = name;
        this.email = email;
        this.phnNum = phnNum;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhnNum() {
        return phnNum;
    }

    public Card getCard() {
        return card;
    }
}
