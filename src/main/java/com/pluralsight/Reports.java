package com.pluralsight;

import java.time.LocalDate;
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
                searchByVendor(transactions);
            case "0":
                return;
            default:
                System.out.println("Invalid option");

        }

    }
}

private static void showMonthToDate(List<transaction> transactions) {
    LocalDate now = LocalDate.now();
    LocalDate startOfMonth = now.withDayOfMonth(1);

    System.out.println("\n--- MONTH TO DATE ---");
    transactions.stream()
            .filter(t -> !t.getDate().isBefore(startOfMonth))
            .forEach(System.out::println);
}

private static void showPreviousMonth(List<transaction> transactions) {
    LocalDate now = LocalDate.now();
    LocalDate firstDayPrevMonth = now.minusMonths(1).withDayOfMonth(1);
    LocalDate lastDayPrevMonth = firstDayPrevMonth.withDayOfMonth(firstDayPrevMonth.lengthOfMonth());

    System.out.println("\n--- PREVIOUS MONTH ---");
    transactions.stream()
            .filter(t -> !t.getDate().isBefore(firstDayPrevMonth) && !t.getDate().isAfter(lastDayPrevMonth))
            .forEach(System.out::println);
}

private static void showYearToDate(List<transaction> transactions) {
    LocalDate now = LocalDate.now();
    LocalDate startOfYear = now.withDayOfYear(1);

    System.out.println("\n--- YEAR TO DATE ---");
    transactions.stream()
            .filter(t -> !t.getDate().isBefore(startOfYear))
            .forEach(System.out::println);
}

private static void showPreviousYear(List<transaction> transactions) {
    LocalDate now = LocalDate.now();
    int previousYear = now.minusYears(1).getYear();

    System.out.println("\n--- PREVIOUS YEAR ---");
    transactions.stream()
            .filter(t -> t.getDate().getYear() == previousYear)
            .forEach(System.out::println);
}
private static void searchByVendor(List<transaction> transactions) {
    System.out.print("\nEnter vendor name: ");
    String vendor = scanner.nextLine().toLowerCase();

    List<transaction> results = transactions.stream()
            .filter(t -> t.getVendor().toLowerCase().contains(vendor))
            .collect(Collectors.toList());

    if (results.isEmpty()) {
        System.out.println("No transactions found for vendor: " + vendor);
    } else {
        System.out.println("\n--- RESULTS FOR " + vendor.toUpperCase() + " ---");
        results.forEach(System.out::println);
    }
}
}