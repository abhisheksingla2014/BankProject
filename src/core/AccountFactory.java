package core;

import core.account.Account;

public class AccountFactory {
    public static Account getInstance(String holderName){
        return new Account(holderName);
    }
}
