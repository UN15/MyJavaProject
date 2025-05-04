package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class Bank {
	private List<Account> accounts = new ArrayList<>();
	private int nextAccountNumber;
	
	public Bank() {
		nextAccountNumber = 1000;
	}
	
	public String createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
		Account savingAccount = new SavingsAccount("AC"+nextAccountNumber, ownerName, initialBalance, interestRate);
		accounts.add(savingAccount);
		nextAccountNumber++;
		return "���� ���°� �����Ǿ����ϴ�: "+savingAccount.toString()+", ������: "+ interestRate+"%";
	}
	
	public String createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
		Account checkingAccount = new CheckingAccount("AC"+nextAccountNumber, ownerName, initialBalance, withdrawalLimit);
		accounts.add(checkingAccount);
		nextAccountNumber++;
		return "üŷ ���°� �����Ǿ����ϴ�: "+ checkingAccount.toString()+", ��� �ѵ�: "+ withdrawalLimit+"��";
	}
	
	public Account findAccount(String accountNumber) throws AccountNotFoundException{
		Account result = null;
		for(Account a : accounts) {
			if(accountNumber.contentEquals(a.getAccountNumber())) {
				result = a;
				break;
			}
		}
		if(result == null) {
			String errMessage = String.format("���� �߻�: ���¹�ȣ %s�� �ش��ϴ� ���¸� ã�� �� �����ϴ�.", accountNumber);
			throw new AccountNotFoundException(errMessage);
		}
		else
			return result;
	}
	
	public void deposit(String accountNumber, double amount){
		Account a;
		try {
			a = findAccount(accountNumber);
			a.deposit(amount);
		} catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}		
	}
	
	public void withdraw(String accountNumber, double amount){
		Account a;
		try {
			a = findAccount(accountNumber);
			try {
				a.withdraw(amount);
			} catch (InsufficientBalanceException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		} 
		catch (AccountNotFoundException e1) {
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}
		
	}
	
	public void transfer(String fromAccountNumber, String toAccountNumber, double amount){
		withdraw(fromAccountNumber, amount);
		deposit(toAccountNumber, amount);
		System.out.println(amount+"���� "+fromAccountNumber+"���� "+ toAccountNumber+"�� �۱ݵǾ����ϴ�.");
	}
	
	public void printAllAccounts() {
		System.out.println("=== ��� ���� ��� ===");
		for(Account a : accounts) {
			if(a instanceof CheckingAccount)
				System.out.println(a.toString()+", ��� �ѵ�: "+((CheckingAccount)a).getWithdrawalLimit()+"��");
			else if(a instanceof SavingsAccount)
				System.out.println(a.toString()+", ������: "+((SavingsAccount)a).getInterestRate()+"%");
		}
		System.out.println("===================");
	}
	
}
