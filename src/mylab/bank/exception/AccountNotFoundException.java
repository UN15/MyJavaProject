package mylab.bank.exception;

public class AccountNotFoundException extends Exception {
	
	public AccountNotFoundException(String errMessage) {
		//�θ��� �����ڸ� ȣ�� ���� �θ� ������ ����
		super(errMessage); //�θ𿡰� �ѱ�
	}
}
