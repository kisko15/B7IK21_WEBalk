package hu.me.iit.HaziElso;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AutoServiceImpl implements AutoService {
	
	private final AutoRepository autoRepository;
	
	public AutoServiceImpl(AutoRepository autoRepository) {
		super();
		this.autoRepository = autoRepository;
	}
	
	@Override
	public List<AutoDto> findAll() {
		return autoRepository.findAll();
	}

	@Override
	public AutoDto getById(String id) {
		return autoRepository.getById(id);
	}

	@Override
	public Long save(AutoDto autoDto) {
		return autoRepository.save(autoDto);
	}

	@Override
	public void deleteById(int id) {
		autoRepository.deleteById(id);
		
	}


}
