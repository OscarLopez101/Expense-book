package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class Reports {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayReports(List<transaction> transactions) {

        System.out.println("\nReports menu");
        System.out.println("1) Month to Date");
        System.out.println("2) previous Month");
        System.out.println("3) Year to Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search by Vendors");
        System.out.println("0) Back");
        System.out.println("chose an option");
        String choice = scanner.nextLine();

        switch (choice) {

            case "1":
                showMonthToDate(transactions);
                break;
            case "2":
                showPreviousMonth(transactions);
                break;
            case "3":
                showYearToDate(transactions);
            case "4":
                showPreviousYear(transactions);
            case "5":
                searchByVendors(transactions);
            case "0":
                return;
            default:
                System.out.println("Invalid option");

        }

    }
}

