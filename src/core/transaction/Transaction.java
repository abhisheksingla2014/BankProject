package core.transaction;

import core.account.Account;

import java.util.Date;

public class Transaction {
    Account entityAccount = null;
    Account counterpartyAccount = null;
    double amount;
    Date date;
    TransactionType type;

    public Transaction(Account entityAccount, Account counterpartyAccount, double amount, Date date,
                       TransactionType type) {
        this.entityAccount = entityAccount;
        this.counterpartyAccount = counterpartyAccount;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    public Account getEntityAccount() {
        return entityAccount;
    }

    public void setEntityAccount(Account entityAccount) {
        this.entityAccount = entityAccount;
    }

    public Account getCounterpartyAccount() {
        return counterpartyAccount;
    }

    public void setCounterpartyAccount(Account counterpartyAccount) {
        this.counterpartyAccount = counterpartyAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
