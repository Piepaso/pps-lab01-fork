package example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount extends AbstractBankAccount {


    public SimpleBankAccount(AccountHolder accountHolder, int i) {
        super(accountHolder, i );
    }

    @Override
    protected double getBalanceAfterWithdraw(double amount) {
        return this.getBalance() - amount;
    }

    @Override
    protected double getMaxWithdrawAmountAllowed() {
        return this.getBalance();
    }
}
