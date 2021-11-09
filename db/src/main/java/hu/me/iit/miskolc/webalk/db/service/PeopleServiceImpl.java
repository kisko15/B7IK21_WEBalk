package hu.me.iit.miskolc.webalk.db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import hu.me.iit.miskolc.webalk.db.repository.PeopleRepository;

@Service
public class PeopleServiceImpl implements PeopleService {
	
	private final PeopleRepository peopleRepository;
	
	public PeopleServiceImpl(PeopleRepository peopleRepository) {
		super();
		this.peopleRepository = peopleRepository;
	}

	@Override
	public Iterable<People> getAllPeaople() {
		List<People> rv = new ArrayList<>();
		
		for (hu.me.iit.miskolc.webalk.db.repository.People people : peopleRepository.findAll()) {
			rv.add(new People(people));
		} 
		
		return rv;
	}
	
	public Iterable<People> getAllPeaople2() {
		
		return StreamSupport.stream(peopleRepository.findAll().spliterator(), false).map(People::new).collect(Collectors.toList());
		
	}

	@Override
	public People create(People people) {
		return new People(peopleRepository.save(people.toEntity()));	
	}

	@Override
	public void deleteById(Long id) {
		peopleRepository.deleteById(id);
	}

}
