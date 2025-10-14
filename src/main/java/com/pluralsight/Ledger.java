package com.pluralsight;

import java.util.List;
import java.util.Scanner;


public class Ledger {

    public static void displayLedger(List<transaction> transactions) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\nLedger menu");
            System.out.println("A) All");
            System.out.println("B) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.println("Chose an option");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {

                case "A":
                    transactions.forEach(System.out::println);
                    break;
                case "D":
                    transactions.stream()
                            .filter(t -> t.getAmount() > 0)
                            .forEach(System.out::println);
                    break;
                case "P":
                    transactions.stream()
                            .filter(t -> t.getAmount() < 0)
                            .forEach(System.out::println);
                    break;
                case "R":
                    Reports.displayReports(transactions);
                    break;
                case "H":
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
            }
        }
    }