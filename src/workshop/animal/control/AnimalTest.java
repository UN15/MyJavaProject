package workshop.animal.control;

import workshop.animal.entity.Animal;
import workshop.animal.entity.Cat;
import workshop.animal.entity.Pet;

public class AnimalTest {

	public static void main(String[] args) {
		//cat 객체를 생성하는 3가지 방법
		Cat cat1 = new Cat(); //5개
		Pet cat2 = new Cat(); //3개
		Animal cat3 = new Cat();//2개
		//Pet로부터 상속받은 메소드 호출
		cat1.setName("톰");
		System.out.println(cat1.getName());
		cat1.play();
		//Animal로부터 상속받은 메소드
		cat1.eat();
		cat1.walk();
		
		cat2.setName("미요");
		System.out.println(cat2.getName());
		cat2.play();
		
		//Animal로부터 상속받은 메소드
		cat3.eat();
		cat3.walk();
		
	}

}
