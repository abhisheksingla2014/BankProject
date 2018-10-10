import core.transaction.TransactionType;
import user.AccountHolder;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws Exception {

        AccountHolder user1 = new AccountHolder("Abhishek");
        AccountHolder user2 = new AccountHolder("kabir");
        String accountID1 = user1.createAccount();
        String accountID2 = user2.createAccount();
        user1.getAmount(accountID1);
        user1.createTransaction(TransactionType.DEPOSITE,1000,accountID1,null);
        user1.getAmount("sjkhdfbsj");
        user1.getAmount(accountID2);
        user1.createTransaction(TransactionType.TRANSFER,500,accountID1,accountID2);
        user1.getAmount(accountID2);
        user1.getAllAccountID();
        user2.getAllAccountID();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("new thread");
            }
        }).start();
        Callable<Integer> x =  new Callable<Integer>() {
            public Integer call() {
                return 0;
            }
        };
    }
}
