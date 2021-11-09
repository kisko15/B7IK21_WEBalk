package hu.me.iit.miskolc.webalk.db.service;

public interface PeopleService {
	
	Iterable<People> getAllPeaople();

	People create(People people);

	void deleteById(Long id);
}
