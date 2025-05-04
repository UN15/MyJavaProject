package mylab.bank.entity;

public class SavingsAccount extends Account{
	private double interestRate;

	public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
		super(accountNumber, ownerName, initialBalance);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void applyInterest() {
		double interest = getBalance() * (interestRate/100);
		deposit(interest);
		System.out.println("이자 "+interest+"원이 적용되었습니다. 현재 잔액: "+ getBalance()+"원");
	}
	

}
