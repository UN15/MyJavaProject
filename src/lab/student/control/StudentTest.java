package lab.student.control;
import lab.student.entity.Student;
import lab.student.exception.GradeException;
public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student("","��μ�", "��ǻ�Ͱ���", 3);
		try {
			System.out.println("5�г����� ����");
			s.setGrade(5);
			
		}catch(GradeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
