package hu.me.iit.gyakorlas.book.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.me.iit.gyakorlas.book.service.Book;
import hu.me.iit.gyakorlas.book.service.BookService;

@RestController
@RequestMapping("/book")
public class BookMainController {

	private final BookService bookService;

	public BookMainController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@GetMapping()
	public Iterable<BookDto> getAllBook() {
		List<BookDto> bookDtoList = new ArrayList<>();
		for (Book book : bookService.getAllBook2()) {
			bookDtoList.add(new BookDto(book));
		}
		return bookDtoList;
	}
	
	@PostMapping(consumes = "application/json")
	public BookDto save(@RequestBody @Valid BookCreateDto bookCreateDto) {
		return new BookDto(bookService.create(bookCreateDto.toBook()));
	}
	
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable ("id") Long id) {
		bookService.delete(id);
	}
	
	@GetMapping("/{id}")
	public BookDto getById(@PathVariable Long id) {
		return new BookDto(bookService.getById(id));			
	}
	
	@PutMapping
	public void save(@RequestBody @Valid BookDto bookDto) {
		bookService.save(bookDto.toBook());
	}
	
	@GetMapping("/list")
	public Iterable<BookDto> findPageNumberBook(@RequestParam("pageNumber") int pageNumber) {
		List<hu.me.iit.gyakorlas.book.controller.BookDto> bookDtos = new ArrayList<>();
		for (Book book : bookService.findByPageNumber(pageNumber)) {
			bookDtos.add(new hu.me.iit.gyakorlas.book.controller.BookDto(book));
		}
		return bookDtos;
	}
}
