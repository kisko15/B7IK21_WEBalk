package hu.me.iit.gyakorlas.Bicycle.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.me.iit.gyakorlas.Bicycle.service.Bicycle;
import hu.me.iit.gyakorlas.Bicycle.service.BicycleService;

@RestController
@RequestMapping("/bicycle")
public class BicycleController {

	private final BicycleService bicycleService;

	public BicycleController(BicycleService bicycleService) {
		super();
		this.bicycleService = bicycleService;
	}
	
	@GetMapping()
	public Iterable<BicycleDto> getAllBicycle() {
		List<BicycleDto> bicyclesDtoList = new ArrayList<>();
		for (Bicycle bicycle : bicycleService.getAllBicycle()) {
			bicyclesDtoList.add(new BicycleDto(bicycle));
		}
		return bicyclesDtoList;
	}
	
	@PostMapping(consumes = "application/json")
	public BicycleDto saveBicycleDto(@RequestBody @Valid BicycleCreateDto bicycleCreateDto) {
		return new BicycleDto(bicycleService.create(bicycleCreateDto.toBicycle()));
	}
	
	@DeleteMapping(path= "/{id}")
	public void delete(@PathVariable ("id") Long id) {
		bicycleService.delete(id);
	}
	
	@GetMapping("/{id}")
	public BicycleDto getById(@PathVariable Long id) {
		return new BicycleDto(bicycleService.getById(id));
	}
	
	@PutMapping
	public void save(@RequestBody @Valid BicycleDto bicycleDto) {
		bicycleService.save(bicycleDto.toBicycle());
	}
	
	@GetMapping("/findByAge")
	public Iterable<BicycleDto> findByAge(@PathParam("age") int age) {
		List<BicycleDto> bicycleDtoList = new ArrayList<>();
		for (Bicycle bicycle : bicycleService.findByAge(age)) {
			bicycleDtoList.add(new BicycleDto(bicycle));
		}
		return bicycleDtoList;
	}
}
