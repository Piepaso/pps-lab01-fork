import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends AbstractBankAccountTest {

    @Override
    protected BankAccount getNewBankAccount(AccountHolder accountHolder) {
        return new SimpleBankAccount(accountHolder, INITIAL_AMOUNT);
    }

    @Override
    protected int getAmountAfterWithdraw() {
        return INITIAL_AMOUNT - WITHDRAWABLE_AMOUNT;
    }

    @Override
    protected int getIllegalWithdrawAmount() {
        return INITIAL_AMOUNT + 1;
    }
}
