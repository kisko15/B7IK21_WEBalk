package hu.me.iit.gyakorlas.Bicycle.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface BicycleRepository extends PagingAndSortingRepository<Bicycle, Long>{

	void save(hu.me.iit.gyakorlas.Bicycle.service.Bicycle bicycle);
	Iterable<Bicycle> findByAge(int age);

}
