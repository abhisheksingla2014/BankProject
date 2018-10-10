package persistance;

import core.transaction.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionPersistance {

    private TransactionPersistance(){}
    private static TransactionPersistance persistance = new TransactionPersistance();
    public static TransactionPersistance getPersistance(){
        return persistance;
    }
    List<Transaction> transactions = new ArrayList<>();


    public List<Transaction> getTransactionOnDate(Date date) {
        return null;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getLastNTransactions(int count) {
        int startInd = Math.max(transactions.size() - count, 0);
        List<Transaction> result = new ArrayList<>(transactions.subList(startInd, transactions.size()-1));
        return result;
    }
}
