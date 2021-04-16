import Services.AccountPrinter;
import Entities.Transaction;
import Utils.TransactionComparator;

import java.util.ArrayList;
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class AccountPrinterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void statementPrintsCorrectly() {
        // expected statement, to be tested against stdout
        String expectedStatement = "date || credit || debit || balance\n";
        expectedStatement += "03/01/2021 || || 2.85 || 122.80\n";
        expectedStatement += "02/01/2021 || 33.50 || || 125.65\n";
        expectedStatement += "02/01/2021 || || 10.00 || 92.15\n";
        expectedStatement += "01/01/2021 || 102.15 || || 102.15\n";

        // creating ArrayList with test transactions
        ArrayList<Transaction> testTransactions = new ArrayList<Transaction>();

        Transaction t1 = new Transaction("01/01/2021", 102.15, 102.15, 1);
        Transaction t2 = new Transaction("02/01/2021", -10.0, 92.15, 1);
        Transaction t3 = new Transaction("02/01/2021", 33.5, 125.65, 2);
        Transaction t4 = new Transaction("03/01/2021", -2.85, 122.8, 1);

        testTransactions.add(t1);
        testTransactions.add(t2);
        testTransactions.add(t3);
        testTransactions.add(t4);

        // sorting transactions
        testTransactions.sort(new TransactionComparator());

        // actual test
        AccountPrinter.printStatement(testTransactions);
        assertEquals(expectedStatement, outContent.toString());
    }
}
