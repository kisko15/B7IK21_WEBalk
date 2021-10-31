package hu.me.iit.HaziElso;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/auto")
public class MainController {

	private final AutoService autoService;
	
	public MainController(AutoService autoService) {
		super();
		this.autoService = autoService;
	}
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	List<AutoDto> AllCars(){
		return autoService.findAll();
	}
	
	@PostMapping(path = "")
	public void newCar(@RequestBody @Validated AutoDto autoDto) {
		autoService.save(autoDto);
	}
	
	@PutMapping(path = "/")
	public void replaceCar(@RequestBody AutoDto autoDto) {
		autoService.save(autoDto);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteCar(@PathVariable("id") String id) {

	}
}
