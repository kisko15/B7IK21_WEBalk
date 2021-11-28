package hu.me.iit.gyakorlas.book.service;

public interface BookService {

	Iterable<Book> getAllBook();

	Iterable<Book> getAllBook2();

	Book create(Book book);

	void delete(Long id);

	Book getById(Long id);

	void save(Book book);

	Iterable<? extends Book> findByPageNumber(int pageNumber);

}
