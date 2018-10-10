package user;

import core.account.Account;
import core.transaction.TransactionType;

import java.util.List;

public interface User {
    String createAccount();
    void deleteAccount(String accountID);
    void getAllAccount();
    void getAllAccountID();
    void getAmount(String accountID);
    void createTransaction(TransactionType type, double amount, String senderId, String receiverID);
}
