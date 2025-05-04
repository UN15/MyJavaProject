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
		shoppingCart.addItem(new Magazine("����ũ�μ���Ʈ ", "2007-10-01", 328, 9900, "�ſ�"));
		shoppingCart.addItem(new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�"));
		shoppingCart.addItem(new Novel("���߿� ", "2007-07-01", 396, 9800, "����������������", "����Ҽ�"));
		shoppingCart.addItem(new Novel("���ѻ꼺 ", "2007-04-14", 383, 11000, "����", "���ϼҼ�"));
		shoppingCart.addItem(new ReferenceBook("�ǿ��������α׷��� ", "2007-01-14", 496, 25000, "����Ʈ�������"));
		shoppingCart.addItem(new Novel("�ҳ��̿´�  ", "2014-05-01", 216, 15000, "�Ѱ�", "����Ҽ�"));
		shoppingCart.addItem(new Novel("�ۺ������ʴ´�  ", "2021-09-09", 332, 15120, "����������������", "����Ҽ�"));
		List<Publication> publications = shoppingCart.getItems();
		
		System.out.println("==== ���� ���� ��� ====");
		shoppingCart.displayCart();
		
		Publication item = publications.get(6);
		int before = item.getPrice();
		
		System.out.println("\n==== ���� ���� ====");
		System.out.println(item.getTitle()+"���� �� ����: " + before+"��");
		manageBook.modifyPrice(shoppingCart.getItems().get(6));
		System.out.println(item.getTitle()+"���� �� ����: " + item.getPrice()+"��");
		System.out.println("����:"+ (before-item.getPrice())+"��");
		
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
