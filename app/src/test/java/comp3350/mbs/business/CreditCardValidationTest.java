package comp3350.mbs.business;

import junit.framework.TestCase;

import org.junit.Test;

public class CreditCardValidationTest extends TestCase {


    public CreditCardValidationTest(String arg0)
    {
        super(arg0);
    }

    boolean valid;

    @Test
    public void testEmpty()
    {
        System.out.println("\nStarting testCreditCardValidation: testEmpty");

        valid = CreditCardValidation.isCardValid("", "", "");

        assertFalse(valid);

        System.out.println("Finished testCalculateTotals: testEmpty");
    }

    @Test
    public void testEmptySecurityCode()
    {
        System.out.println("\nStarting testCreditCardValidation: EmptySecurityCode");

        valid = CreditCardValidation.isCardValid("1234123412341234", "1020", "");

        assertFalse(valid);

        System.out.println("Finished testCalculateTotals: EmptySecurityCode");
    }

    @Test
    public void testEmptyExpiryDate()
    {
        System.out.println("\nStarting testCreditCardValidation: EmptyExpiryDate");
        valid = CreditCardValidation.isCardValid("1234123412341234", "", "123");

        assertFalse(valid);

        System.out.println("Finished testCalculateTotals: EmptyExpiryDate");
    }

    @Test
    public void testEmptyCardNumber()
    {
        System.out.println("\nStarting testCreditCardValidation: EmptyCardNumber");

        valid = CreditCardValidation.isCardValid("", "1020", "123");

        assertFalse(valid);

        System.out.println("Finished testCalculateTotals: EmptyCardNumber");
    }

    @Test
    public void testInvalidCardNumberLength()
    {
        System.out.println("\nStarting testCreditCardValidation: InvalidCardNumberLength");

        valid = CreditCardValidation.isCardValid("123", "1020", "123");

        assertFalse(valid);

        System.out.println("Finished testCalculateTotals: InvalidCardNumberLength");
    }

    @Test
    public void testInvalidSecurityCodeLength() {
        System.out.println("\nStarting testCreditCardValidation: InvalidSecurityCodeLength");

        valid = CreditCardValidation.isCardValid("1234123412341234", "1020", "1");

        assertFalse(valid);

        System.out.println("Finished testCalculateTotals: InvalidSecurityCodeLength");
    }

    @Test
    public void testInvalidExpiryDateLength()
    {
        System.out.println("\nStarting testCreditCardValidation: InvalidExpiryLength");

        valid = CreditCardValidation.isCardValid("1234123412341234", "10", "123");

        assertFalse(valid);

        System.out.println("Finished testCalculateTotals: InvalidExpiryLength");
    }

    @Test
    public void testCardNumberShortBy1()
    {
        System.out.println("\nStarting testCreditCardValidation: CardNumberShortBy1");

        valid = CreditCardValidation.isCardValid("123412341234123", "1020", "123");

        assertFalse(valid);

        System.out.println("Finished testCalculateTotals: CardNumberShortBy1");
    }

    @Test
    public void testSecurityCodeShortBy1() {
        System.out.println("\nStarting testCreditCardValidation: SecurityCodeShortBy1");

        valid = CreditCardValidation.isCardValid("1234123412341234", "1020", "12");

        assertFalse(valid);

        System.out.println("Finished testCalculateTotals: SecurityCodeShortBy1");
    }


    @Test
    public void testExpiryDateCurrentYearJulyInvalid() {
        System.out.println("\nStarting testCreditCardValidation: ExpiryDateCurrentYearJulyInvalid");

        valid = CreditCardValidation.isCardValid("1234123412341234", "0720", "123");

        assertFalse(valid);

        System.out.println("Finished testCalculateTotals: ExpiryDateCurrentYearJulyInvalid");
    }

    @Test
    public void testExpiryDateCurrentYearAugustValid() {
        System.out.println("\nStarting testCreditCardValidation: ExpiryDateCurrentYearAugustValid");

        valid = CreditCardValidation.isCardValid("1234123412341234", "0820", "123");

        assertTrue(valid);

        System.out.println("Finished testCalculateTotals: ExpiryDateCurrentYearAugustValid");
    }

    @Test
    public void testExpiryDateCurrentYearDecemberValid() {
        System.out.println("\nStarting testCreditCardValidation: testExpiryDateCurrentYearDecemberValid");

        valid = CreditCardValidation.isCardValid("1234123412341234", "1220", "123");

        assertTrue(valid);

        System.out.println("Finished testCalculateTotals: testExpiryDateCurrentYearDecemberValid");
    }

    @Test
    public void testExpiryDateCurrentYearMonth13Invalid() {
        System.out.println("\nStarting testCreditCardValidation: testExpiryDateCurrentYearMonth13Invalid");

        valid = CreditCardValidation.isCardValid("1234123412341234", "1320", "123");

        assertFalse(valid);

        System.out.println("Finished testCalculateTotals: testExpiryDateCurrentYearMonth13Invalid");
    }

    @Test
    public void testExpiryDatePreviousYear() {
        System.out.println("\nStarting testCreditCardValidation: testExpiryDatePreviousYear");

        valid = CreditCardValidation.isCardValid("1234123412341234", "1019", "123");

        assertFalse(valid);

        System.out.println("Finished testCalculateTotals: testExpiryDatePreviousYear");
    }

    @Test
    public void testExpiryDateFutureYearValid() {
        System.out.println("\nStarting testCreditCardValidation: testExpiryDateFutureYearValid");

        valid = CreditCardValidation.isCardValid("1234123412341234", "1021", "123");

        assertTrue(valid);

        System.out.println("Finished testCalculateTotals: testExpiryDateFutureYearValid");
    }

    @Test
    public void testExpiryDateFutureYearMonth0() {
        System.out.println("\nStarting testCreditCardValidation: testExpiryDateFutureYearValid");

        valid = CreditCardValidation.isCardValid("1234123412341234", "0021", "123");

        assertFalse(valid);

        System.out.println("Finished testCalculateTotals: testExpiryDateFutureYearValid");
    }

    @Test
    public void testExpiryDateFutureYearJanuary() {
        System.out.println("\nStarting testCreditCardValidation: testExpiryDateFutureYearJanuary");

        valid = CreditCardValidation.isCardValid("1234123412341234", "0121", "123");

        assertTrue(valid);

        System.out.println("Finished testCalculateTotals: testExpiryDateFutureYearJanuary");
    }

    @Test
    public void testExpiryDateFutureYearDecember() {
        System.out.println("\nStarting testCreditCardValidation: testExpiryDateFutureYearJanuary");

        valid = CreditCardValidation.isCardValid("1234123412341234", "1221", "123");

        assertTrue(valid);

        System.out.println("Finished testCalculateTotals: testExpiryDateFutureYearJanuary");
    }

    @Test
    public void testExpiryDateFutureYearMonth13() {
        System.out.println("\nStarting testCreditCardValidation: testExpiryDateFutureYearJanuary");

        valid = CreditCardValidation.isCardValid("1234123412341234", "1321", "123");

        assertFalse(valid);

        System.out.println("Finished testCalculateTotals: testExpiryDateFutureYearJanuary");
    }

}
