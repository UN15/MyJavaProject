package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Book> books = new ArrayList<>();
	private String name;
	
	public Library(String name) {
		this.name = name;
	}
	
	public void addBook(Book book) {
		books.add(book);
		System.out.println("도서가 추가되었습니다: "+ book.getTitle());
		
	}
	
	public Book findBookByTitle(String title) {
		Book result = null;
		for(Book book: books) {
			if(book.getTitle().equals(title)) {
				result = book;
				break;
			}
		}
		return result;
	}
	
	public List<Book> findBooksByAuthor(String author) {
		List<Book> result = new ArrayList<>(); 
		for(Book book: books) {
			if(book.getAuthor().equals(author)) {
				result.add(book);
			}
		}
		return result;
	}
	
	public Book findBookByISBN(String isbn) {
		Book result = null;
		for(Book book: books) {
			if(book.getIsbn().equals(isbn)) {
				result = book;
				break;
			}
		}
		return result;
	}
	
	public boolean checkOutBook(String isbn) {
		for(Book book: books) {
			if(book.getIsbn().equals(isbn)) {
				return book.checkOut();
			}
		}
		return false;
	}
	
	public boolean returnBook(String isbn) {
		for(Book book: books) {
			if(book.getIsbn().equals(isbn)) {
				book.returnBook();
				return true;
			}
		}
		return false;
	}
	
	public List<Book> getAvailableBooks(){
		List<Book> result = new ArrayList<>();
		for(Book book: books) {
			if(book.isAvailable()) {
				result.add(book);
			}
		}
		return result;
	}
	
	public List<Book> getAllBooks(){
		return books;
	}
	
	public int getTotalBooks() {
		return books.size();
	}
	
	public int getAvailableBooksCount() {
		int count = 0;
		for(Book book: books) {
			if(book.isAvailable())
				count++;
		}
		return count;
	}
	public int getBorrowedBooksCount() {
		int count = 0;
		for(Book book: books) {
			if(!book.isAvailable())
				count++;
		}
		return count;
	}
}
