package com.pluralsight;

<<<<<<< HEAD
public class Main {
=======
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Transaction> Transactions = TransactionFileManager.loadTransactions();
        Menu.homeScreen(Transactions);
    }
>>>>>>> 011d1e6862553f6a0c0a0f5fc5f26855f6c869b1
}
