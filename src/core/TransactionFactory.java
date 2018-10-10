package core;

import core.account.Account;
import core.transaction.Transaction;
import core.transaction.TransactionType;

import java.util.Date;

public class TransactionFactory {
    public static Transaction getInstance(Account entity, Account counterParty, double amount, Date date, TransactionType type){
        return new Transaction(entity, counterParty, amount, date, type);
    }
}
