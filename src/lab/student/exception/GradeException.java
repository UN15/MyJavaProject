package lab.student.exception;

public class GradeException extends Exception {
	
	public GradeException(String errMessage) {
		//부모의 생성자를 호출 변수 부모가 가지고 있음
		super(errMessage); //부모에게 넘김
	}
}
