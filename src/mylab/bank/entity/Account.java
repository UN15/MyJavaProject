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
		System.out.println(amount+"���� �ԱݵǾ����ϴ�. ���� �ܾ�: "+ balance+"��");
	}
	
	public void withdraw(double amount) throws WithdrawalLimitExceededException {	
		if(balance < amount){
			String errMessage = String.format("���� �߻�: �ܾ��� �ʰ��߽��ϴ�. �ܾ�: %f��", balance);
			throw new WithdrawalLimitExceededException(errMessage);
		}
		else {
			balance-=amount;
			System.out.println(amount+"���� ��ݵǾ����ϴ�. ���� �ܾ�: "+ balance+"��");
		}
	}

	@Override
	public String toString() {
		return "���¹�ȣ: " + accountNumber + ", ������: " + ownerName + ", �ܾ�: " + balance + "��";
	}
	
}
