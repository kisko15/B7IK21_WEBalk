package hu.me.iit.HaziElso;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AutoMemoryRepository implements AutoRepository{

	private final List<AutoDto> auto = new ArrayList<>();
	
	private int findAutoById(int id) {
        int found = -1;
        for (int i = 0; i < auto.size(); i++) {
            if (auto.get(i).getId() == id ) {
                found = i;
                break;
            }
        }
        return found;
    }
	
	@Override
	public List<AutoDto> findAll() {
		return auto;
	}

	@Override
	public AutoDto getById(String id) {
		return null;
	}

	@Override
	public Long save(AutoDto autoDto) {
		int found = findAutoById(autoDto.getId());
		
		if(found != -1) {
			AutoDto foundcar = auto.get(found);
			foundcar.setAjtokszama(autoDto.getAjtokszama());
			foundcar.setFerohelyekszama(autoDto.getFerohelyekszama());
			foundcar.setGyartasiIdo(autoDto.getGyartasiIdo());
			foundcar.setGyarto(autoDto.getGyarto());
			foundcar.setKivitel(autoDto.getKivitel());
			foundcar.setModell(autoDto.getModell());
			foundcar.setRendszam(autoDto.getRendszam());
			foundcar.setSzin(autoDto.getSzin());
			foundcar.setUzemanyagtipus(autoDto.getUzemanyagtipus());
			foundcar.setValtotipus(autoDto.getValtotipus());
		}else {
			auto.add(autoDto);
		}
		return null;
	}

	@Override
	public void deleteById(int id) {
		
		int found = findAutoById(id);
		
		if(found != -1) {
			auto.remove(found);
		}
	}
	
	
}
