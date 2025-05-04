package mylab.bank.entity;

import mylab.bank.exception.WithdrawalLimitExceededException;

public abstract class Account {
	private String accountNumber;
	private String ownerName;
	private double balance;
	
	public Account(String accountNumber, String ownerName, double initialBalance) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = initialBalance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance+=amount;
		System.out.println(amount+"원이 입금되었습니다. 현재 잔액: "+ balance+"원");
	}
	
	public void withdraw(double amount) throws WithdrawalLimitExceededException {	
		if(balance < amount){
			String errMessage = String.format("예외 발생: 잔액을 초과했습니다. 잔액: %f원", balance);
			throw new WithdrawalLimitExceededException(errMessage);
		}
		else {
			balance-=amount;
			System.out.println(amount+"원이 출금되었습니다. 현재 잔액: "+ balance+"원");
		}
	}

	@Override
	public String toString() {
		return "계좌번호: " + accountNumber + ", 소유자: " + ownerName + ", 잔액: " + balance + "원";
	}
	
}
