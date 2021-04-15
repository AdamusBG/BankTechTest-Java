package Utils;

import Entities.Transaction;

import java.util.Comparator;

public class TransactionComparator implements Comparator<Transaction> {
    @Override
    public int compare(Transaction t1, Transaction t2) {
        if (t1.getDate().equals(t2.getDate())) {
            return t2.getNumberInDay() - t1.getNumberInDay();
        }
        return t2.getDate().compareTo(t1.getDate());
    }
}