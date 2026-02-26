package example.model;

public abstract class AbstractBankAccount implements BankAccount {
	private double balance;
	private final AccountHolder holder;

	public AbstractBankAccount(final AccountHolder holder, final double balance) {
		this.holder = holder;
		if (balance < 0) {
			throw new IllegalArgumentException("Initial balance cannot be negative");
		}
		this.balance = balance;
	}

	@Override
	public double getBalance() {
		return this.balance;
	}

	@Override
	public void deposit(final int userID, final double amount) {
		if (checkUser(userID)) {
			if (amount > 0)
				this.balance += amount;
			else
				throw new IllegalArgumentException("Amount must be positive");
		}
	}

	@Override
	public void withdraw(final int userID, final double amount) {
		if (checkUser(userID)) {
			if (isWithdrawAllowed(amount)) {
				this.balance = getBalanceAfterWithdraw(amount);
			} else {
				throw new IllegalArgumentException("Amount must be positive and less than current balance");
			}
		}
	}

	abstract protected double getBalanceAfterWithdraw(double amount);

	private boolean isWithdrawAllowed(final double amount){
		return amount > 0 && amount < getMaxWithdrawAmountAllowed();
	}

	abstract protected double getMaxWithdrawAmountAllowed();

	private boolean checkUser(final int id) {
		return this.holder.id() == id;
	}
}
