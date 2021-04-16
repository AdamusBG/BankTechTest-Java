package Entities;

import Utils.AccountUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Account {

    private ArrayList<Transaction> transactions;
    private int balance;

    public Account() {
        this.transactions = new ArrayList<Transaction>();
        this.balance = 0;
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    public double getBalance() {
        return (double) this.balance / 100;
    }

    public void withdraw(double amount) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        withdraw(formatter.format(Calendar.getInstance().getTime()), amount);
    }

    public void withdraw(String date, double amount) {
        if (!AccountUtils.isValidDate(date)) {
            System.out.println(String.format("The given date of '%s' is invalid, please provide a valid date in format dd/mm/yyyy", date));
            System.out.println("This transaction has been cancelled");
            return;
        }
        if (amount < 0) {
            System.out.println("The amount must be positive");
            System.out.println("This transaction has been cancelled");
            return;
        }
        if (!AccountUtils.enoughForWithdrawal(this.balance, amount)) {
            System.out.println("There is not enough balance to process this transaction");
            System.out.println("This transaction has been cancelled");
            return;
        }
        changeBalance(-1 * amount);
        recordTransaction(date, -1 * amount);
    }

    public void deposit(double amount) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        deposit(formatter.format(Calendar.getInstance().getTime()), amount);
    }

    public void deposit(String date, double amount) {
        if (!AccountUtils.isValidDate(date)) {
            System.out.println(String.format("The given date of '%s' is invalid, please provide a valid date in format dd/mm/yyyy", date));
            System.out.println("This transaction has been cancelled");
            return;
        }
        if (amount < 0) {
            System.out.println("The amount must be positive");
            System.out.println("This transaction has been cancelled");
            return;
        }
        changeBalance(amount);
        recordTransaction(date, amount);
    }

    private void changeBalance(double amount) {
        int minorUnitAmount = (int) (amount * 100);
        this.balance += minorUnitAmount;
    }

    private void recordTransaction(String date, double amount) {
        int numberInDay = transactionsOnThisDate(date) + 1;
        Transaction toRecord = new Transaction(date, amount, getBalance(), numberInDay);
        this.transactions.add(toRecord);
    }

    private int transactionsOnThisDate(String date) {
        int transactionsOnDate = 0;
        for (Transaction t : this.transactions) {
            if (t.getDateAsString().equals(date)) {
                transactionsOnDate += 1;
            }
        }
        return transactionsOnDate;
    }
}
