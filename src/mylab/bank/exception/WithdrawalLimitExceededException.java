package mylab.bank.exception;

public class WithdrawalLimitExceededException extends InsufficientBalanceException {
	public WithdrawalLimitExceededException(String errMessage) {
		//�θ��� �����ڸ� ȣ�� ���� �θ� ������ ����
		super(errMessage); //�θ𿡰� �ѱ�
	}
}
