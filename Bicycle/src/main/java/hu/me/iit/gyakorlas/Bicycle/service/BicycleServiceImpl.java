package hu.me.iit.gyakorlas.Bicycle.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import hu.me.iit.gyakorlas.Bicycle.repository.BicycleRepository;

@Service
public class BicycleServiceImpl implements BicycleService {
	
	private final BicycleRepository bicycleRepository;

	public BicycleServiceImpl(BicycleRepository bicycleRepository) {
		super();
		this.bicycleRepository = bicycleRepository;
	}

	@Override
	public Iterable<Bicycle> getAllBicycle() {
		List<Bicycle> bicyclesList = new ArrayList<>();
		for (hu.me.iit.gyakorlas.Bicycle.repository.Bicycle bicycle : bicycleRepository.findAll()) {
			bicyclesList.add(new Bicycle(bicycle));
		}
		return bicyclesList;
	}
	
	
	public Iterable<Bicycle> getAllBicycle2() {
		return StreamSupport.stream(bicycleRepository.findAll().spliterator(), false).map(Bicycle::new).collect(Collectors.toList());
	}

	@Override
	public Bicycle create(Bicycle bicycle) {
		return new Bicycle(bicycleRepository.save(bicycle.toEntity()));
	}

	@Override
	public void delete(Long id) {
		try {
			bicycleRepository.deleteById(id);
		} catch (EmptyResultDataAccessException ex) {
			throw new NoSuchEntityException(id);
		}
		
	}

	@Override
	public Bicycle getById(Long id) {
		Optional<hu.me.iit.gyakorlas.Bicycle.repository.Bicycle> optionalBicycle = bicycleRepository.findById(id);
		if (optionalBicycle.isEmpty()) {
			throw new NoSuchEntityException(id);
		}
		return new Bicycle(optionalBicycle.get()); 
	}

	@Override
	public void save(Bicycle bicycle) {
		Optional<hu.me.iit.gyakorlas.Bicycle.repository.Bicycle> optionalBicycle = bicycleRepository.findById(bicycle.getId());
		if (optionalBicycle.isEmpty()) {
			throw new NoSuchEntityException(bicycle.getId());
		}
		bicycleRepository.save(bicycle.toEntity());
	}

	@Override
	public Iterable<? extends Bicycle> findByAge(int age) {
		return StreamSupport.stream(bicycleRepository.findByAge(age).spliterator(), false).map(Bicycle::new).collect(Collectors.toList());
	}
	
}
