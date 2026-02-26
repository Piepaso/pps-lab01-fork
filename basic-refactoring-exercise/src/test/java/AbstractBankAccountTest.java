import example.model.AccountHolder;
import example.model.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AbstractBankAccountTest {

	protected final static int INITIAL_AMOUNT = 100;
	protected final static int WITHDRAWABLE_AMOUNT = Math.min(70, INITIAL_AMOUNT);
	private AccountHolder accountHolder;
	private BankAccount bankAccount;
	private final int ID = 1;

	@BeforeEach
	void beforeEach(){
		accountHolder = new AccountHolder("Mario", "Rossi", ID);
		bankAccount = getNewBankAccount(accountHolder);
	}

	abstract protected BankAccount getNewBankAccount(AccountHolder accountHolder);

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
		assertEquals(getAmountAfterWithdraw(), bankAccount.getBalance());
	}

	abstract protected int getAmountAfterWithdraw();

	@Test
	void testWrongUserWithdraw() {
		bankAccount.withdraw(ID + 1, WITHDRAWABLE_AMOUNT);
		assertEquals(INITIAL_AMOUNT, bankAccount.getBalance());

	}

	@Test
	void testIllegalAmountWithdraw() {
		assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(ID, -1));
		assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(ID, getIllegalWithdrawAmount()));
		assertEquals(INITIAL_AMOUNT, bankAccount.getBalance());
	}

	abstract protected int getIllegalWithdrawAmount();
}
