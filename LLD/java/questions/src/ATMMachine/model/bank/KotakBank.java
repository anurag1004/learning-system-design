package ATMMachine.model.bank;

import ATMMachine.model.account.Account;
import ATMMachine.model.card.Card;
import ATMMachine.model.enums.BankName;
import ATMMachine.model.exceptions.NoSuchCardExistException;
import ATMMachine.model.user.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class KotakBank implements Bank{
    private BankName bankName = BankName.KOTAK;
    Map<Integer, Account> accountMap;
    Map<Integer, Integer> cardToAccountMap;
    public KotakBank(){
        accountMap = new HashMap<>();
        cardToAccountMap = new HashMap<>();
    }

    public String getBankName() {
        return bankName.toString();
    }
    public Account createNewAccount(String name, String email, String phnNum){
        User user = new User(name, email, phnNum);
        int acNo = new Random().nextInt(10000000-100001)+100001;
        int cardNo = new Random().nextInt(30000000-20000001)+20000001;
        int cvv = new Random().nextInt(999-101)+100;
        int pin = new Random().nextInt(999999-100001)+100001;
        LocalDate expiryDate = LocalDate.now().plusYears(5);
        Card card = new Card(cardNo, cvv, expiryDate, user, pin);
        Account account = new Account(acNo, user);
        account.setLinkedCard(card);
        accountMap.put(acNo, account);
        cardToAccountMap.put(cardNo, acNo);
        // for debugging purpose
        System.out.printf("USER_NAME: %s, CARD_NO: %d, PIN: %d\n", name, card.getCardNo(), card.getPin());
        return account;
    }
    public Account getAcLinkedWithCard(int cardNo) throws NoSuchCardExistException {
        if(!cardToAccountMap.containsKey(cardNo)){
            throw new NoSuchCardExistException(String.format("Invalid card: %d\n", cardNo));
        }
        int acNo = cardToAccountMap.get(cardNo);
        return accountMap.get(acNo);
    }
}
