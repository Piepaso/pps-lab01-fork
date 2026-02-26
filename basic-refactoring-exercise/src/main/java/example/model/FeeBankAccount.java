package example.model;

public class FeeBankAccount extends AbstractBankAccount {

    private final double withdrawFee;

    public FeeBankAccount(AccountHolder holder, double balance, double withdrawFee) {
        super(holder, balance);
        if (withdrawFee < 0) {
            throw new IllegalArgumentException("Withdraw fee cannot be negative");
        }
        this.withdrawFee = withdrawFee;
    }

    @Override
    protected double getBalanceAfterWithdraw(double amount) {
        return getBalance() - amount - withdrawFee;
    }

    @Override
    protected double getMaxWithdrawAmountAllowed() {
        return getBalance() - withdrawFee;
    }
}
