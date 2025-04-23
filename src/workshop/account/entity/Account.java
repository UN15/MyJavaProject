package workshop.account.entity;

import workshop.account.exception.InsufficientBalanceException;

public class Account extends Object { //extends Object가 숨겨져 있음
	private String custId; //고객번호
	private String acctId; //계좌번호
	private int balance; //잔액
	
	//Default Contructor(생성자)
	public Account() {
		System.out.println("Default Constructor Called..");
	}
	//Constructor Overloading(생성자 중복정의)
	public Account(String custId, String acctId, int balance) {
		this.custId = custId;
		this.acctId = acctId;
		this.balance = balance;
	}
	//setter
	public void setCustId(String custId) {
		this.custId = custId;
	}
	
	

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	
//	public void setBalance(int newBalance) {
//		this.balance = newBalance;
//	}
	
	//getter
	public String getCustId() {
		return custId;
	}
	
	public String getAcctId() {
		return acctId;
	}
	
	public int getBalance() {
		return balance;
	}
	//입금
	public void deposit(int amount) {
		this.balance+=amount;
	}
	//출금
	public void withdraw(int amount) throws InsufficientBalanceException {
		if(amount>balance) {
			String errMessage = String.format("잔액이 부족합니다. (요청 금액: %d, 현재 잔액: %d)", amount, balance);
			throw new InsufficientBalanceException(errMessage);
		}
		this.balance -= amount;
	}

	//부모 클래스가 가진 Object의 toString() 메소드를 재정의(Overriding)
	//Method Signature public String toString()
	@Override
	public String toString() {
		return "Account [custId=" + custId + ", acctId=" + acctId + ", balance=" + balance + "]";
	}
}
