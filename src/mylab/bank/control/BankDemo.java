package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;

public class BankDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank b = new Bank();
		System.out.println("=== ���� ���� ===");
		System.out.println(b.createSavingsAccount("ȫ�浿", 10000.0, 3.0));
		System.out.println(b.createCheckingAccount("��ö��", 20000.0, 5000));
		System.out.println(b.createSavingsAccount("�̿���", 30000.0, 2.0));
		
		b.printAllAccounts();
		
		System.out.println("=== �Ա�/��� �׽�Ʈ ===");
		b.deposit("AC1000", 5000.0);
		b.withdraw("AC1001", 3000.0);
		
		System.out.println("=== ���� ���� �׽�Ʈ ===");	
		try {
			SavingsAccount savingAccount = (SavingsAccount)b.findAccount("AC1000");
			savingAccount.applyInterest();
		} catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("=== ���� ��ü �׽�Ʈ ===");	
		b.transfer("AC1002", "AC1001", 5000.0);
		
		b.printAllAccounts();

		b.withdraw("AC1001", 6000.0);
		b.withdraw("AC1001", 5500.0);
		b.withdraw("AC9999", 5000.0);
		
	}

}
