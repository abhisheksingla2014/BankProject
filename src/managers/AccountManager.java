package managers;

import core.AccountFactory;
import core.account.Account;
import persistance.AccountPersistance;

import java.util.List;

public class AccountManager {

    AccountPersistance persistance = AccountPersistance.getInstance();

    private AccountManager(){}
    private static AccountManager manager = new AccountManager();
    public static AccountManager getInstance(){
        return manager;
    }
    public String createAccount(String holderName) {
        Account account = AccountFactory.getInstance(holderName);
        AccountPersistance.getInstance().addAccount(account);
        return account.getId();
    }

    public void deleteAccount(String id) {
        persistance.removeAccount(id);
    }
    public void displayAccount(){
        List<Account> accounts = persistance.getAllAccounts();
        for(Account account : accounts){
            System.out.println(account.getId());
        }
    }
    public double getAmount(String id){
        return persistance.getAccountByID(id).getAmount();
    }
}