package workshop.book.control;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;

public class ManageBook {

	public static void main(String[] args) {
		//Publication Ÿ�� �迭�� ���� �� ����
		Publication[] pubs = new Publication[5];
		pubs[0] = new Magazine("����ũ�μ���Ʈ","2007-10-01",328,9900,"�ſ�");


		//Magazine ��ü ����
		Magazine mz = new Magazine();//��ӹް� ������ ������ �ִ� �޼ҵ���� �� 5�� ��� ����
		//mz�� pubs�� �߰��� �� ����
		Publication pub = new Magazine(); //��ӹ��� �޼ҵ常 �� 4�� ��� ���� �޼ҵ� ������ �پ������ 
		//��Ÿ�ӿ� �����Ǵ� ��ü�� �Ѳ����� �迭�� ���� �� ���� publication Ÿ����
		//���� ���� Ŭ������ publication���� ���� �ٷ� �� ����
		
		//Novel ��ü ����
		Novel novel = new Novel();
		Publication pub2 = new Novel();
	}
}
