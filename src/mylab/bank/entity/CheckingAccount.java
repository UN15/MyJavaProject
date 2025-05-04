package mylab.bank.entity;

import mylab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
	private double withdrawalLimit;

	public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double withdrawalLimit) {
		super(accountNumber, ownerName, initialBalance);
		this.withdrawalLimit = withdrawalLimit;		
	}

	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}

	public void withdraw(double amount) throws WithdrawalLimitExceededException{
		if(withdrawalLimit < amount){
			String errMessage = String.format("���� �߻�: ��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: %.1f��", withdrawalLimit);
			throw new WithdrawalLimitExceededException(errMessage);
		}
		else
			super.withdraw(amount);
	}
	
	
}
