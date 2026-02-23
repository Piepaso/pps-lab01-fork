import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    private final static int INITIAL_AMOUNT = 100;
    private final int WITHDRAWABLE_AMOUNT = Math.min(70, INITIAL_AMOUNT);
    private final int ID = 1;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", ID);
        bankAccount = new SimpleBankAccount(accountHolder, INITIAL_AMOUNT);
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        final int amount = 100;
        bankAccount.deposit(ID, amount);
        assertEquals(INITIAL_AMOUNT + amount, bankAccount.getBalance());
    }

    @Test
    void testWrongUserDeposit() {
        bankAccount.deposit(ID + 1, 50);
        assertEquals(INITIAL_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testIllegalAmountDeposit() {
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(ID, -1));
        assertEquals(INITIAL_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.withdraw(accountHolder.id(), WITHDRAWABLE_AMOUNT);
        assertEquals(INITIAL_AMOUNT - WITHDRAWABLE_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongUserWithdraw() {
        bankAccount.withdraw(ID + 1, WITHDRAWABLE_AMOUNT);
        assertEquals(INITIAL_AMOUNT, bankAccount.getBalance());

    }

    @Test
    void testIllegalAmountWithdraw() {
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(ID, -1));
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(ID, INITIAL_AMOUNT + 1));
        assertEquals(INITIAL_AMOUNT, bankAccount.getBalance());
    }
}
