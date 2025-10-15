package com.pluralsight;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<transaction> transactions = TransactionFileManager.loadTransactions();
        Menu.homeScreen(transactions);
    }
}
