import Entities.Transaction;
import Utils.TransactionComparator;

import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    Transaction testTransaction;

    @Test
    void correctlyGetsDateAfterInitialization_getDate() {
        initializeTestTransaction();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        assertEquals("14/04/2021", formatter.format(testTransaction.getDate().getTime()));
    }

    @Test
    void correctlyGetsMovementAfterInitialization_getMovement() {
        initializeTestTransaction();

        assertEquals(123.45, testTransaction.getMovement());
    }

    @Test
    void correctlyGetsBalanceAfterInitialization_getBalance() {
        initializeTestTransaction();

        assertEquals(1230.50, testTransaction.getBalance());
    }

    @Test
    void correctlyGetsNumberInDayAfterInitialization_getNumberInDay() {
        initializeTestTransaction();

        assertEquals(3, testTransaction.getNumberInDay());
    }

    @Test
    void severalTransactionsInArrayListCanBeSorted() {
        // initialize ArrayList to be sorted
        ArrayList<Transaction> transactionList = new ArrayList<Transaction>();

        // creating dummy transactions to add
        Transaction t1 = new Transaction("01/01/2021", 10.00, 0.0, 1);
        Transaction t2 = new Transaction("01/01/2021", 20.00, 0.0, 2);
        Transaction t3 = new Transaction("01/01/2021", 30.00, 0.0, 3);
        Transaction t4 = new Transaction("02/01/2021", 40.00, 0.0, 1);
        Transaction t5 = new Transaction("02/01/2021", 50.00, 0.0, 2);
        Transaction t6 = new Transaction("03/01/2021", 60.00, 0.0, 1);

        // adding transactions in random order
        transactionList.add(t4);
        transactionList.add(t6);
        transactionList.add(t2);
        transactionList.add(t5);
        transactionList.add(t3);
        transactionList.add(t1);

        // sorting call
        transactionList.sort(new TransactionComparator());

        // testing that sorting has worked correctly
        assertEquals(10.00, transactionList.get(0).getMovement());
        assertEquals(20.00, transactionList.get(1).getMovement());
        assertEquals(30.00, transactionList.get(2).getMovement());
        assertEquals(40.00, transactionList.get(3).getMovement());
        assertEquals(50.00, transactionList.get(4).getMovement());
        assertEquals(60.00, transactionList.get(5).getMovement());
    }



    private void initializeTestTransaction() {
        this.testTransaction = new Transaction("14/04/2021", 123.45, 1230.50, 3);
    }
}
