package lab.student.entity;
import lab.student.exception.GradeException;
public class Student {
	private String studentId;
	private String name;
	private String major;
	private int grade;
	//������
	public Student(String studentId, String name, String major, int grade) {
		this.studentId = studentId;
		this.name = name;
		this.major = major;
		this.grade = grade;
	}
	//getter
	public String getStudentId() {
		return studentId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMajor() {
		return major;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) throws GradeException {
		if(grade<1 || grade>4) {
			String errMessage = String.format("�г��� 1 ~ 4 ���̿��� �մϴ�. ���� ��û �г�: %d, ���� �г�:%d �Դϴ�.", grade, this.grade);
			throw new GradeException(errMessage);
		}
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return name + " / " + major + " / " + grade + "�г�";
	}
	
}
