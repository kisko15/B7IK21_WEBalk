package hu.me.iit.miskolc.webalk.db;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl implements PeopleService {
	
	private final PeopleRepository peopleRepository;
	
	public PeopleServiceImpl(PeopleRepository peopleRepository) {
		super();
		this.peopleRepository = peopleRepository;
	}

	@Override
	public Iterable<People> getAllPeaople() {
		
		return peopleRepository.findAll();
	}

}
