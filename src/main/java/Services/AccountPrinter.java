package Services;

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

    private static void printTransactionCancelled() {
        System.out.println("This transaction has been cancelled");
    }
}
