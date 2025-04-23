package lab.student.entity;
import lab.student.exception.GradeException;
public class Student {
	private String studentId;
	private String name;
	private String major;
	private int grade;
	//생성자
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
			String errMessage = String.format("학년은 1 ~ 4 사이여야 합니다. 변경 요청 학년: %d, 현재 학년:%d 입니다.", grade, this.grade);
			throw new GradeException(errMessage);
		}
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return name + " / " + major + " / " + grade + "학년";
	}
	
}
