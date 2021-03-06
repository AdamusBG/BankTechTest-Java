package Entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.lang.Integer.parseInt;

public class Transaction {

    private final Calendar date;
    private final double movement;
    private final double balance;
    private final int numberInDay;

    public Transaction(String transactionDate, double movement, double balance, int numberInDay) {
        this.date = Calendar.getInstance();
        this.movement = movement;
        this.balance = balance;
        this.numberInDay = numberInDay;
        setDate(transactionDate);
    }

    public Calendar getDate() {
        return this.date;
    }

    public String getDateAsString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(this.date.getTime());
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
        String[] parts = transactionDate.split("/");
        this.date.set(parseInt(parts[2]), parseInt(parts[1]) - 1, parseInt(parts[0]));
    }
}
