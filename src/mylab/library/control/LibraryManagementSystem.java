package mylab.library.control;

import java.util.List;

import mylab.library.entity.Book;
import mylab.library.entity.Library;

public class LibraryManagementSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Library testLibrary = new Library("testLibrary");
		LibraryManagementSystem lms = new LibraryManagementSystem();
		
		lms.addSampleBooks(testLibrary);
		
		System.out.println("===== �߾� ������ =====");
		lms.displayAvailableBooks(testLibrary);
		System.out.println();
		
		System.out.println("===== ���� �˻� �׽�Ʈ =====");
		lms.testFindBook(testLibrary);
		System.out.println();

		System.out.println("===== ���� ���� �׽�Ʈ =====");
		lms.testCheckout(testLibrary);
		System.out.println();

		System.out.println("������ ���� ����:");
		lms.displayAvailableBooks(testLibrary);
		System.out.println();

		System.out.println("===== ���� �ݳ� �׽�Ʈ =====");
		lms.testReturn(testLibrary);
		System.out.println();

		System.out.println("������ ���� ����:");
		lms.displayAvailableBooks(testLibrary);
		System.out.println();

		System.out.println("===== ���� ������ ���� ��� =====");
		List<Book> availableBooks= testLibrary.getAvailableBooks();
		for(Book b: availableBooks) {
			System.out.println(b.toString());
			System.out.println("------------------------");
		}
	}
	
	private void addSampleBooks(Library library) {
		library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
	}
	
	private void testFindBook(Library library) {
		System.out.println("�������� �˻� ���:");
		Book titleResult = library.findBookByTitle("�ڹ��� ����");
		if(titleResult != null)
			System.out.println(titleResult.toString());
		else
			System.out.println("ã�� ���߽��ϴ�.");
		
		System.out.println();

		System.out.println("���ڷ� �˻� ���:");
		List<Book> authorResult = library.findBooksByAuthor("Robert C. Martin");		
		if(authorResult.isEmpty())
			System.out.println("ã�� ���߽��ϴ�.");
		else {
			for(Book b: authorResult)
				System.out.println(b.toString());
		}
	}
	
	private void testCheckout(Library library) {
		boolean check = library.checkOutBook("978-89-01-14077-4");
		
		if(check) {
			System.out.println("���� ���� ����!");
			System.out.println("����� ���� ����:");
			Book book = library.findBookByISBN("978-89-01-14077-4");
			System.out.println(book.toString());
		}
		else 
			System.out.println("���� ���� ����");

	}

	private void testReturn(Library library) {
		boolean check = library.returnBook("978-89-01-14077-4");
		if(check) {
			System.out.println("���� �ݳ� ����!");
			System.out.println("�ݳ��� ���� ����:");
			Book book = library.findBookByISBN("978-89-01-14077-4");
			System.out.println(book.toString());
		}
		else
			System.out.println("���� �ݳ� ����");

	}
	
	private void displayAvailableBooks(Library library) {
		System.out.println("��ü ������: "+ library.getTotalBooks());
		System.out.println("���� ���� ���� ��: "+ library.getAvailableBooksCount());
		System.out.println("���� ���� ���� ��: "+ library.getBorrowedBooksCount());
	}
}
