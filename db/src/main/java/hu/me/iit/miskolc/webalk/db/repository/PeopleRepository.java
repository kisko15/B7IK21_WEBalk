package hu.me.iit.miskolc.webalk.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PeopleRepository extends PagingAndSortingRepository<People, Long> {

	void save(hu.me.iit.miskolc.webalk.db.service.People people);
	Iterable<People> findAllByAgeGreaterThanEqual(int age);

}
