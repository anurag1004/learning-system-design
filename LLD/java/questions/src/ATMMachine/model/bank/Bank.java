package ATMMachine.model.bank;

import ATMMachine.model.account.Account;
import ATMMachine.model.exceptions.NoSuchCardExistException;

public interface Bank {
    String getBankName();
    Account createNewAccount(String name, String email, String phnNum);
    Account getAcLinkedWithCard(int cardNo) throws NoSuchCardExistException;
}
