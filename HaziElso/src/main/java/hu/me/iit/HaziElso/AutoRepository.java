package hu.me.iit.HaziElso;

import java.util.List;

public interface AutoRepository {

	List<AutoDto> findAll();
	AutoDto getById(String id);
	Long save(AutoDto autoDto);
	void deleteById(int id);
}
