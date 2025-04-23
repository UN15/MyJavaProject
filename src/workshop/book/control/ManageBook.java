package workshop.book.control;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;

public class ManageBook {

	public static void main(String[] args) {
		//Publication 타입 배열을 선언 및 생성
		Publication[] pubs = new Publication[5];
		pubs[0] = new Magazine("마이크로소프트","2007-10-01",328,9900,"매월");


		//Magazine 객체 생성
		Magazine mz = new Magazine();//상속받고 본인이 가지고 있는 메소드까지 총 5개 사용 가능
		//mz는 pubs에 추가할 수 없음
		Publication pub = new Magazine(); //상속받은 메소드만 총 4개 사용 가능 메소드 범위가 줄어들지만 
		//런타임에 생성되는 객체를 한꺼번에 배열로 묶을 수 있음 publication 타입임
		//개별 하위 클래스를 publication으로 묶어 다룰 수 있음
		
		//Novel 객체 생성
		Novel novel = new Novel();
		Publication pub2 = new Novel();
	}
}
