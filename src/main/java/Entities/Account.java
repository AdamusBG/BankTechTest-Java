package Entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Account {

    private ArrayList<Transaction> transactions;
    private double balance;

    public Account() {
        this.transactions = new ArrayList<Transaction>();
        this.balance = 0.0;
    }

    public void withdraw(double amount) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        withdraw(formatter.format(Calendar.getInstance().getTime()), amount);
    }

    public void withdraw(String date, double amount) {
        // check date format
        // check amount positive
        // check enough balance to make withdrawal
        // actually reduce balance, maybe by calling private method
        // add a transaction object to arraylist
    }

    public void add(double amount) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        add(formatter.format(Calendar.getInstance().getTime()), amount);
    }

    public void add(String date, double amount) {
        // check date format
        // check amount positive
        // actually reduce balance, maybe by calling private method
        // add a transaction object to arraylist
    }
}
