package persistance;

import core.account.Account;

import java.util.*;

public class AccountPersistance{

    private AccountPersistance(){}
    private static AccountPersistance persistance = new AccountPersistance();
    public static AccountPersistance getInstance(){
        return persistance;
    }
    private static List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }
    public void removeAccount(String id) {
        for(ListIterator<Account> itr = accounts.listIterator(); itr.hasNext();){
            Account account = itr.next();
            if(account.getId() == id){
                itr.remove();
                break;
            }
        }
    }

    public Account getAccountByID(String accountID){
        for(Account account: accounts){
            if(account.getId() == accountID){
                return account;
            }
        }
        return null;
    }

    public List<Account> getAllAccounts() {
        List<Account> result = new ArrayList<>(accounts.subList(0,accounts.size()-1));
        return result;
    }
}
