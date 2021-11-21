package hu.me.iit.miskolc.webalk.db.service;

public interface PeopleService {

	Iterable<People> getAllPeaople();

	People create(People people);

	//void deleteById(Long id);

	void delete(Long id);

	People getById(Long id);

	void save(People people);

	Iterable<? extends People> findByAgeGreatherThan(int age);

}
