package hu.me.iit.miskolc.webalk.db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.dao.EmptyResultDataAccessException;
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

		return StreamSupport.stream(peopleRepository.findAll().spliterator(), false).map(People::new)
				.collect(Collectors.toList());

	}

	@Override
	public People create(People people) {
		return new People(peopleRepository.save(people.toEntity()));
	}

	/*
	 * @Override public void deleteById(Long id) { peopleRepository.deleteById(id);
	 * }
	 */

	@Override
	public void delete(Long id) {
		try {
			peopleRepository.deleteById(id);
		} catch (EmptyResultDataAccessException ex) {
			throw new NoSuchEntityException(id);
		}
	}

	@Override
	public People getById(Long id) {
		Optional<hu.me.iit.miskolc.webalk.db.repository.People> optionalPeople = peopleRepository.findById(id);
		if (optionalPeople.isEmpty()) {
			throw new NoSuchEntityException(id);
		}
		return new People(optionalPeople.get());
	}

	@Override
	public void save(People people) {
		Optional<hu.me.iit.miskolc.webalk.db.repository.People> optionalPeople = peopleRepository
				.findById(people.getId());
		if (optionalPeople.isEmpty()) {
			throw new NoSuchEntityException(people.getId());
		}
		peopleRepository.save(people.toEntity());
	}

	@Override
	public Iterable<? extends People> findByAgeGreatherThan(int age) {
		return StreamSupport.stream(peopleRepository.findAllByAgeGreaterThanEqual(age).spliterator(), false)
				.map(People::new).collect(Collectors.toList());
	}

	public Iterable<People> getAllPeople2() {
		return StreamSupport.stream(peopleRepository.findAll().spliterator(), false).map(People::new)
				.collect(Collectors.toList());
	}

}
