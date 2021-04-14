import Entities.Transaction;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;

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

    private void initializeTestTransaction() {
        this.testTransaction = new Transaction("14/04/2021", 123.45, 1230.50, 3);
    }
}
