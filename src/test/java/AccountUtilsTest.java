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
}
