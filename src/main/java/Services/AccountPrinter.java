package Services;

import Entities.Transaction;

import java.util.ArrayList;

public class AccountPrinter {
    public static void printIncorrectDateMessage(String date) {
        System.out.println(String.format("The given date of '%s' is invalid, please provide a valid date in format dd/mm/yyyy", date));
        printTransactionCancelled();
    }

    public static void printAmountMustBePositive() {
        System.out.println("The amount must be positive");
        printTransactionCancelled();
    }

    public static void printNotEnoughBalance() {
        System.out.println("There is not enough balance to process this transaction");
        printTransactionCancelled();
    }

    public static void printStatement(ArrayList<Transaction> transactions) {
        String statementToPrint = "date || credit || debit || balance\n";
        for (Transaction t : transactions) {
            statementToPrint += t.getDateAsString();
            if (t.getMovement() >= 0) {
                statementToPrint += String.format(" || %.02f || || ", t.getMovement());
            } else {
                statementToPrint += String.format(" || || %.02f || ", t.getMovement() * -1);
            }
            statementToPrint += String.format("%.02f\n", t.getBalance());
        }
        System.out.print(statementToPrint);
    }

    private static void printTransactionCancelled() {
        System.out.println("This transaction has been cancelled");
    }
}
