package Entities;

import java.util.Calendar;

import static java.lang.Integer.parseInt;

public class Transaction {

    private final Calendar date;
    private final double movement;
    private final double balance;
    private final int numberInDay;

    // can reduce this to a single constructor if account class always passes date

    public Transaction(double movement, double balance, int numberInDay) {
        this.date = Calendar.getInstance();
        this.movement = movement;
        this.balance = balance;
        this.numberInDay = numberInDay;
    }

    public Transaction(String transactionDate, double movement, double balance, int numberInDay) {
        this(movement, balance, numberInDay);
        setDate(transactionDate);
    }

    public Calendar getDate() {
        return this.date;
    }

    public double getMovement() {
        return this.movement;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getNumberInDay() {
        return this.numberInDay;
    }

    private void setDate(String transactionDate) {
        // Could check date here
        String[] parts = transactionDate.split("/");
        this.date.set(parseInt(parts[2]), parseInt(parts[1]) - 1, parseInt(parts[0]));
    }
}
