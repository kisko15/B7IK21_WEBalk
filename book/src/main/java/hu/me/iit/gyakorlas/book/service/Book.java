package hu.me.iit.gyakorlas.book.service;

public class Book {

	private Long id;
	private String author;
	private String bookName;
	private int pageNumber;
	
	public Book() {
		
	}
	public Book(Long id, String author, String bookName, int pageNumber) {
		super();
		this.id = id;
		this.author = author;
		this.bookName = bookName;
		this.pageNumber = pageNumber;
	}
	public Book(hu.me.iit.gyakorlas.book.repository.Book book) {
		super();
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
	
	public hu.me.iit.gyakorlas.book.repository.Book toEntity() {
		return new hu.me.iit.gyakorlas.book.repository.Book(id, author, bookName, pageNumber);
	}
}
