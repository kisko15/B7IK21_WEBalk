package hu.me.iit.miskolc.webalk.db.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.me.iit.miskolc.webalk.db.service.People;
import hu.me.iit.miskolc.webalk.db.service.PeopleService;

@RestController
@RequestMapping("/people")
public class PeopleController {

	private final PeopleService peopleService;
	
	public PeopleController(PeopleService peopleService) {
		super();
		this.peopleService = peopleService;
	}

	@GetMapping()
	Iterable<PeopleDto> getAllPeaople() {
		List<PeopleDto> peopleDtoList = new ArrayList<>();
		for(People people : peopleService.getAllPeaople()) {
			peopleDtoList.add(new PeopleDto(people));
		}
		
		return peopleDtoList;
	}
	
	@PostMapping(consumes = "application/json")
	public PeopleDto save(@RequestBody @Valid PeopleCreateDto peopleCreateDto) {
		return new PeopleDto(peopleService.create(peopleCreateDto.toPeople()));
	}
	
	@DeleteMapping(path= "{id}")
	public void delete(@PathVariable ("id") Long id) {
		peopleService.deleteById(id);
	}
}
