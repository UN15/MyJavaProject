package mylab.book.control;

import java.util.ArrayList;
import java.util.List;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class ShoppingCart {
	private List<Publication> items;

	public ShoppingCart() {
		items = new ArrayList<>();
	}

	public void addItem(Publication item) {
		items.add(item);
	}

	public List<Publication> getItems() {
		return items;
	}

	public void setItems(List<Publication> items) {
		this.items = items;
	}

	public boolean removeItem(String title) {
		for (Publication item : items) {
			if (item.getTitle().equals(title)) {
				items.remove(item);
				return true;
			}
		}

		return false;
	}

	public void displayCart() {
		for (int i = 1; i <= items.size(); i++) {
			if (items.get(i - 1) instanceof Magazine) {
				Magazine item = (Magazine) items.get(i - 1);
				System.out.println(i + ". " + item.getTitle() + "[잡지] 발행주기:" + item.getPublishPeriod() + ", "
						+ item.getPage() + "쪽, " + item.getPrice() + "원, 출판일: " + item.getPublishDate());
			} else if (items.get(i - 1) instanceof Novel) {
				Novel item = (Novel) items.get(i - 1);
				System.out
						.println(i + ". " + item.getTitle() + "[소설] 저자:" + item.getAuthor() + ", 장르: " + item.getGenre()
								+ ", " + item.getPage() + "쪽, " + item.getPrice() + "원, 출판일: " + item.getPublishDate());
			} else if (items.get(i - 1) instanceof ReferenceBook) {
				ReferenceBook item = (ReferenceBook) items.get(i - 1);
				System.out.println(i + ". " + item.getTitle() + "[참고서] 분야:" + item.getField() + ", " + item.getPage()
						+ "쪽, " + item.getPrice() + "원, 출판일: " + item.getPublishDate());
			}
		}
	}

	public int calculateTotalPrice() {
		int totalPrice = 0;
		for (Publication item : items)
			totalPrice += item.getPrice();
		return totalPrice;
	}

	public int calculateDiscountedPrice() {
		int total = 0;
		for (Publication item : items) {
			if (item instanceof Magazine)
				total+=item.getPrice() * 0.9;
			else if (item instanceof Novel)
				total+=item.getPrice() * 0.85;
			else if (item instanceof ReferenceBook)
				total+=item.getPrice() * 0.8;
		}
		return total;
	}
}
