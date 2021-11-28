package hu.me.iit.gyakorlas.book.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long>{

	void save(hu.me.iit.gyakorlas.book.service.Book book);

	Iterable<Book> findByPageNumber(int pageNumber);
}
