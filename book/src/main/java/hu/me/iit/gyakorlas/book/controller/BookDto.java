package hu.me.iit.gyakorlas.book.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import hu.me.iit.gyakorlas.book.service.Book;

public class BookDto {

	private Long id;
	
	@NotEmpty
	private String author;
	
	@NotEmpty
	private String bookName;
	
	@NotNull
	private int pageNumber;
	
	public BookDto() {
		super();
	}
	public BookDto(Book book) {
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
		return new Book(id, author, bookName, pageNumber);
	}
	
}
