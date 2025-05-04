package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;

public class BankDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank b = new Bank();
		System.out.println("=== 계좌 생성 ===");
		System.out.println(b.createSavingsAccount("홍길동", 10000.0, 3.0));
		System.out.println(b.createCheckingAccount("김철수", 20000.0, 5000));
		System.out.println(b.createSavingsAccount("이영희", 30000.0, 2.0));
		
		b.printAllAccounts();
		
		System.out.println("=== 입금/출금 테스트 ===");
		b.deposit("AC1000", 5000.0);
		b.withdraw("AC1001", 3000.0);
		
		System.out.println("=== 이자 적용 테스트 ===");	
		try {
			SavingsAccount savingAccount = (SavingsAccount)b.findAccount("AC1000");
			savingAccount.applyInterest();
		} catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("=== 계좌 이체 테스트 ===");	
		b.transfer("AC1002", "AC1001", 5000.0);
		
		b.printAllAccounts();

		b.withdraw("AC1001", 6000.0);
		b.withdraw("AC1001", 5500.0);
		b.withdraw("AC9999", 5000.0);
		
	}

}
