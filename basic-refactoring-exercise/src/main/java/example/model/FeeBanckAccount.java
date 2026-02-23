package example.model;

public class FeeBanckAccount implements BankAccount {
    public FeeBanckAccount(AccountHolder accountHolder, int initialAmount, int withdrawFee) {
    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public void deposit(int userID, double amount) {

    }

    @Override
    public void withdraw(int userID, double amount) {

    }
}
