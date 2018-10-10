package user;

import core.account.Account;
import core.transaction.TransactionType;
import managers.AccountManager;
import managers.TransactionManager;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountHolder implements User {

    TransactionManager transactionManager = TransactionManager.getInstance();
    AccountManager accountManager = AccountManager.getInstance();
    List<String> accounts = new ArrayList<>();
    String name;

    public AccountHolder(String name) {
        this.name = name;
    }

    private boolean validateAccount(String accountID){
        for(Iterator<String> itr =  accounts.listIterator();itr.hasNext();){
            String availableAccount = itr.next();
            if(accountID == availableAccount){
                return true;
            }
        }
        return false;
    }

    @Override
    public String createAccount() {
        String accountId = accountManager.createAccount(this.name);
        accounts.add(accountId);
        return accountId;
    }

    @Override
    public void deleteAccount(String accountID) {
        accountManager.deleteAccount(accountID);
        for(Iterator<String> itr =  accounts.listIterator();itr.hasNext();){
            String availableAccount = itr.next();
            if(accountID == availableAccount){
                itr.remove();
                break;
            }
        }
    }

    @Override
    public void getAllAccount() {
        accountManager.displayAccount();
    }

    @Override
    public void  getAllAccountID() {
        for(String account: accounts ){
            System.out.println(account);
        }
    }

    @Override
    public void getAmount(String accountID) {
        if(!validateAccount(accountID)){
            System.out.println("Account Invalid");
            return;
        }
        System.out.println(accountManager.getAmount(accountID));
    }

    @Override
    public void createTransaction(TransactionType type, double amount,String entityID, String counterPartyID) {
        switch(type){
            case DEPOSITE:
                transactionManager.createDeposite(entityID,amount);
                break;
            case WITHDRAW:
                transactionManager.createWithdraw(entityID,amount);
                break;
            case TRANSFER:
                transactionManager.createTransfer(entityID,counterPartyID,amount);
                break;
            default:
                System.out.println("Not a transaction type");
        }
    }
}
