package hu.me.iit.gyakorlas.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import hu.me.iit.gyakorlas.book.repository.BookRepository;

@Service
public class BookServiceIml implements BookService{
	
	private final BookRepository bookRepository;
	
	public BookServiceIml(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public Iterable<Book> getAllBook() {
		List<Book> bookService = new ArrayList<>();
		for (hu.me.iit.gyakorlas.book.repository.Book book : bookRepository.findAll()) {
			bookService.add(new Book(book));
		}
		return bookService;
	}
	
	@Override
	public Iterable<Book> getAllBook2() {
		return StreamSupport.stream(bookRepository.findAll().spliterator(), false).map(Book::new).collect(Collectors.toList());
	}

	@Override
	public Book create(Book book) {
		return new Book(bookRepository.save(book.toEntity()));
	}

	@Override
	public void delete(Long id) {
		try {
			bookRepository.deleteById(id);
		} catch (EmptyResultDataAccessException ex){
			throw new NoSuchEntityException(id);
		}
	}

	@Override
	public Book getById(Long id) {
		Optional<hu.me.iit.gyakorlas.book.repository.Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isEmpty()) {
			throw new NoSuchEntityException(id);
		}
		return new Book(optionalBook.get());
	}

	@Override
	public void save(Book book) {
		Optional<hu.me.iit.gyakorlas.book.repository.Book> optionalBook = bookRepository.findById(book.getId());
		if (optionalBook.isEmpty()) {
			throw new NoSuchEntityException(book.getId());
		}
		bookRepository.save(book.toEntity());
	}

	@Override
	public Iterable<? extends Book> findByPageNumber(int pageNumber) {
		return StreamSupport.stream(bookRepository.findByPageNumber(pageNumber).spliterator(), false).map(Book::new).collect(Collectors.toList());
	}
	

}
