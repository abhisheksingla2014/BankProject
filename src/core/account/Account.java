package core.account;

import core.transaction.Transaction;
import core.transaction.TransactionType;
import managers.TransactionManager;

import java.util.ArrayList;
import java.util.List;

public class Account {
    String id;
    String holderName;
    double amount;
    public static List<Transaction> transactionHistory = new ArrayList<>();

    public Account(String holderName) {
        this.holderName = holderName;
        this.id = IDGenerator.generateID(holderName);
        this.amount =0;
    }
    public String getId() {
        return id;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void addAmount(double amount) {
        this.amount += amount;
    }

    public void removeAmount(double amount) {
        this.amount -= amount;
    }
}
