package mylab.book.entity;

public class Magazine extends Publication{
	private String publishPeriod;

	public Magazine(String title, String publishDate, int page, int price, String publishPeriod) {
		super(title, publishDate, page, price);
		this.publishPeriod = publishPeriod;
	}

	public String getPublishPeriod() {
		return publishPeriod;
	}

	@Override
	public String toString() {
		return "Magazine [publishPeriod=" + publishPeriod + "]";
	}
	
	
}
