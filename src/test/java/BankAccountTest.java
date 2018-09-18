import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

public class BankAccountTest {
    public static final int balance = 5000;
    public static final int sum = 3000;
    private BankAccount bankAccount;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void init()
    {
        bankAccount = new BankAccount();
        bankAccount.setBalance(balance);
        bankAccount.setSum(sum);
    }
    @Test
    public void verifyCredit()
    {
        int expected = 8000;
        int actual = bankAccount.credit();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void verifyDebitPos()
    {
        int expected = 2000;
        int actual = bankAccount.debit();
        Assert.assertEquals(expected, actual);
    }
}
