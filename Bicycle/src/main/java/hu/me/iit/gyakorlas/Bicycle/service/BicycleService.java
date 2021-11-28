package hu.me.iit.gyakorlas.Bicycle.service;

public interface BicycleService {

	Iterable<Bicycle> getAllBicycle();

	Bicycle create(Bicycle bicycle);

	void delete(Long id);

	Bicycle getById(Long id);

	void save(Bicycle bicycle);

	Iterable<? extends Bicycle> findByAge(int age);

}
