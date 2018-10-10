package managers;

import core.TransactionFactory;
import core.account.Account;
import core.transaction.Transaction;
import core.transaction.TransactionType;
import persistance.AccountPersistance;
import persistance.TransactionPersistance;

import java.util.Date;

public class TransactionManager {

    private TransactionManager(){}
    private static TransactionManager transactionManager = new TransactionManager();
    private static AccountPersistance accountPersistance = AccountPersistance.getInstance();
    public static TransactionManager getInstance(){
        return transactionManager;
    }
    private TransactionPersistance persistance= TransactionPersistance.getPersistance();

    private Transaction createTransaction(Account entity, Account counterParty, double amount, Date date,
                                          TransactionType type){
        Transaction transaction = TransactionFactory.getInstance(entity,counterParty,amount, date ,type);
        return transaction;
    }

    public void createDeposite(String accountID, double amount) {
        if(amount < 0){
            System.out.println("Transaction Failed : Amount less than 0");
        }
        Account account = accountPersistance.getAccountByID(accountID);
        account.addAmount(amount);
        Transaction transaction =
                createTransaction(account,null,amount, new java.util.Date() ,TransactionType.DEPOSITE);
        persistance.addTransaction(transaction);
    }

    public void createWithdraw(String accountID, double amount) {
        if(amount > 0){
            System.out.println("Transaction Failed : Amount greater than 0");
        }
        Account account = accountPersistance.getAccountByID(accountID);
        account.addAmount(amount);
        Transaction transaction =
                createTransaction(account,null,amount, new java.util.Date() ,TransactionType.WITHDRAW);
        persistance.addTransaction(transaction);
    }

    public void createTransfer(String senderID, String receiverID, double amount) {
        Account sender = accountPersistance.getAccountByID(senderID);
        Account receiver = accountPersistance.getAccountByID(receiverID);
        sender.removeAmount(amount);
        receiver.addAmount(amount);
        Transaction transaction =
                createTransaction(sender,receiver,amount, new java.util.Date() ,TransactionType.TRANSFER);
        persistance.addTransaction(transaction);
    }
}
