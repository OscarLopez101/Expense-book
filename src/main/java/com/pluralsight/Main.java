package com.pluralsight;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Transaction> Transactions = TransactionFileManager.loadTransactions();
        Menu.homeScreen(Transactions);
    }
}
