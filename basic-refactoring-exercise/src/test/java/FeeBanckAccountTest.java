import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.FeeBanckAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeeBanckAccountTest {
    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    private final int WITHDRAW_FEE = 1;
    private final int INITIAL_AMOUNT = 100;
    private final int WITHDRAWABLE_AMOUNT = Math.min(70, INITIAL_AMOUNT - WITHDRAW_FEE);
    private final int ID = 1;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", ID);
        bankAccount = new FeeBanckAccount(accountHolder, INITIAL_AMOUNT, WITHDRAW_FEE);
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
    void testWrongDeposit() {
        bankAccount.deposit(ID + 1, 50);
        assertEquals(INITIAL_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.withdraw(accountHolder.id(), WITHDRAWABLE_AMOUNT);
        assertEquals(INITIAL_AMOUNT - WITHDRAWABLE_AMOUNT - WITHDRAW_FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.withdraw(ID + 1, WITHDRAWABLE_AMOUNT);
        assertEquals(INITIAL_AMOUNT, bankAccount.getBalance());
    }
}
