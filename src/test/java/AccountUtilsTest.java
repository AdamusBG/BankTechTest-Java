import Utils.AccountUtils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountUtilsTest {

    @Test
    void returnsTrueForValidDate_isValidDate() {
        assertTrue(AccountUtils.isValidDate("15/04/2021"));
        assertTrue(AccountUtils.isValidDate("29/02/2020"));
        assertTrue(AccountUtils.isValidDate("01/01/2001"));
    }

    @Test
    void returnsFalseForInvalidDate_isValidDate() {
        assertFalse(AccountUtils.isValidDate("29/02/2021"));
        assertFalse(AccountUtils.isValidDate("35/05/2021"));
        assertFalse(AccountUtils.isValidDate("03/14/2021"));
    }

    @Test
    void returnsTrueWhenResultBalanceAboveZero_enoughForWithdrawal() {
        assertTrue(AccountUtils.enoughForWithdrawal(150.00, 34.27));
        assertTrue(AccountUtils.enoughForWithdrawal(99.99, 42.19));
    }

    @Test
    void returnsTrueWhenResultBalanceZero_enoughForWithdrawal() {
        assertTrue(AccountUtils.enoughForWithdrawal(150.00, 150.00));
        assertTrue(AccountUtils.enoughForWithdrawal(99.99, 99.99));
    }

    @Test
    void returnsFalseWhenResultBalanceBelowZero_enoughForWithdrawal() {
        assertFalse(AccountUtils.enoughForWithdrawal(150.00, 162.75));
        assertFalse(AccountUtils.enoughForWithdrawal(99.99, 100.00));
    }
}
