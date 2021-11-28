package hu.me.iit.gyakorlas.book.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import hu.me.iit.gyakorlas.book.service.Book;

public class BookCreateDto {

	private Long id;
	
	@NotEmpty
	private String author;
	
	@NotEmpty
	private String bookName;
	
	@Min(50)
	private int pageNumber;
	
	public BookCreateDto() {
	
	}
	public BookCreateDto(Book book) {
		this.id = book.getId();
		this.author = book.getAuthor();
		this.bookName = book.getBookName();
		this.pageNumber = book.getPageNumber();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public Book toBook() {
		return new Book(null, author, bookName, pageNumber);
	}
}
