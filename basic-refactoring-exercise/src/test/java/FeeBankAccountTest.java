import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.FeeBankAccount;

public class FeeBankAccountTest extends AbstractBankAccountTest{
    private final int WITHDRAW_FEE = 1;

    @Override
    protected BankAccount getNewBankAccount(AccountHolder accountHolder) {
        return new FeeBankAccount(accountHolder, INITIAL_AMOUNT, WITHDRAW_FEE);
    }

    @Override
    protected int getAmountAfterWithdraw() {
        return INITIAL_AMOUNT - WITHDRAWABLE_AMOUNT - WITHDRAW_FEE;
    }

    @Override
    protected int getIllegalWithdrawAmount() {
        return INITIAL_AMOUNT - WITHDRAW_FEE + 1;
    }
}
