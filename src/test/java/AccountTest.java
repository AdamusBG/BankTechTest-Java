import Entities.Account;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import Entities.Transaction;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class AccountTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private Account testAccount;

    // test setup

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(outContent));
        testAccount = new Account();
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    // tests for balance

    @Test
    void zeroBalanceAfterInitialization_getBalance() {
        assertEquals(0, testAccount.getBalance());
    }

    @Test
    void correctBalanceAfterOneDeposit_deposit_getBalance() {
        testAccount.deposit(55.55);
        assertEquals(55.55, testAccount.getBalance());
    }

    @Test
    void correctBalanceAfterSeveralDeposits_deposit_getBalance() {
        testAccount.deposit(55.55);
        testAccount.deposit(11.11);
        testAccount.deposit(33.33);
        testAccount.deposit(66.66);
        assertEquals(166.65, testAccount.getBalance());
    }

    @Test
    void correctBalanceAfterDepositAndWithdrawal_deposit_withdrawal_getBalance() {
        testAccount.deposit(55.55);
        testAccount.withdraw(11.11);
        assertEquals(44.44, testAccount.getBalance());
    }

    @Test
    void correctBalanceAfterSeveralDepositsAndWithdrawals_deposit_withdrawal_getBalance() {
        testAccount.deposit(55.55);
        testAccount.deposit(20.00);
        testAccount.withdraw(11.11);
        testAccount.deposit(3.23);
        testAccount.withdraw(25.01);
        testAccount.deposit(1.23);
        assertEquals(43.89, testAccount.getBalance());
    }

    // tests for transactions

    @Test
    void noTransactionsAfterInitializations_getTransactions() {
        ArrayList<Transaction> ts = testAccount.getTransactions();
        assertEquals(0, ts.size());
    }

    @Test
    void correctNumberOfTransactionsAfterOneDeposit_deposit_getTransactions() {
        testAccount.deposit(55.55);
        ArrayList<Transaction> ts = testAccount.getTransactions();
        assertEquals(1, ts.size());
    }

    @Test
    void correctNumberOfTransactionsAfterSeveralDeposits_deposit_getTransactions() {
        testAccount.deposit(55.55);
        testAccount.deposit(11.11);
        testAccount.deposit(33.33);
        testAccount.deposit(66.66);
        ArrayList<Transaction> ts = testAccount.getTransactions();
        assertEquals(4, ts.size());
    }

    @Test
    void correctNumberOfTransactionsAfterSeveralDepositsAndWithdrawals_deposit_withdraw_getTransactions() {
        testAccount.deposit(55.55);
        testAccount.deposit(20.00);
        testAccount.withdraw(11.11);
        testAccount.deposit(3.23);
        testAccount.withdraw(25.01);
        testAccount.deposit(1.23);
        ArrayList<Transaction> ts = testAccount.getTransactions();
        assertEquals(6, ts.size());
    }

    // tests for error messages being printed correctly

    @Test
    void invalidDateMessagePrintedCorrectly_withdraw() {
        testAccount.withdraw("33/02/2021", 100.00);
        String expectedMessage = "The given date of '33/02/2021' is invalid, please provide a valid date in format dd/mm/yyyy\nThis transaction has been cancelled\n";
        assertEquals(expectedMessage, outContent.toString());
    }

    @Test
    void negativeAmountMessagePrintedCorrectly_withdraw() {
        testAccount.withdraw(-100.00);
        String expectedMessage = "The amount must be positive\nThis transaction has been cancelled\n";
        assertEquals(expectedMessage, outContent.toString());
    }

    @Test
    void notEnoughBalanceMessagePrintedCorrectly_withdraw() {
        testAccount.withdraw(100.00);
        String expectedMessage = "There is not enough balance to process this transaction\nThis transaction has been cancelled\n";
        assertEquals(expectedMessage, outContent.toString());
    }

    @Test
    void invalidDateMessagePrintedCorrectly_deposit() {
        testAccount.deposit("33/02/2021", 100.00);
        String expectedMessage = "The given date of '33/02/2021' is invalid, please provide a valid date in format dd/mm/yyyy\nThis transaction has been cancelled\n";
        assertEquals(expectedMessage, outContent.toString());
    }

    @Test
    void negativeAmountMessagePrintedCorrectly_deposit() {
        testAccount.deposit(-100.00);
        String expectedMessage = "The amount must be positive\nThis transaction has been cancelled\n";
        assertEquals(expectedMessage, outContent.toString());
    }
}
