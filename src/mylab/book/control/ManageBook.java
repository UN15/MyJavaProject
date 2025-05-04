package mylab.book.control;

import java.util.List;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class ManageBook {

	public static void main(String[] args) {
		ManageBook manageBook = new ManageBook();
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.addItem(new Magazine("마이크로소프트 ", "2007-10-01", 328, 9900, "매월"));
		shoppingCart.addItem(new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"));
		shoppingCart.addItem(new Novel("빠삐용 ", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"));
		shoppingCart.addItem(new Novel("남한산성 ", "2007-04-14", 383, 11000, "김훈", "대하소설"));
		shoppingCart.addItem(new ReferenceBook("실용주의프로그래머 ", "2007-01-14", 496, 25000, "소프트웨어공학"));
		shoppingCart.addItem(new Novel("소년이온다  ", "2014-05-01", 216, 15000, "한강", "장편소설"));
		shoppingCart.addItem(new Novel("작별하지않는다  ", "2021-09-09", 332, 15120, "베르나르베르베르", "장편소설"));
		List<Publication> publications = shoppingCart.getItems();
		
		System.out.println("==== 도서 정보 출력 ====");
		shoppingCart.displayCart();
		
		Publication item = publications.get(6);
		int before = item.getPrice();
		
		System.out.println("\n==== 가격 변경 ====");
		System.out.println(item.getTitle()+"변경 전 가격: " + before+"원");
		manageBook.modifyPrice(shoppingCart.getItems().get(6));
		System.out.println(item.getTitle()+"변경 후 가격: " + item.getPrice()+"원");
		System.out.println("차액:"+ (before-item.getPrice())+"원");
		
		StatisticsAnalyzer st = new StatisticsAnalyzer();
		st.printStatistics(publications.toArray(new Publication[0]));

	}

	public void modifyPrice(Publication item) {
		if (item instanceof Magazine)
			item.setPrice((int) (item.getPrice() * 0.6));
		else if (item instanceof Novel)
			item.setPrice((int) (item.getPrice() * 0.8));
		else if (item instanceof ReferenceBook)
			item.setPrice((int) (item.getPrice() * 0.9));
	}
}
