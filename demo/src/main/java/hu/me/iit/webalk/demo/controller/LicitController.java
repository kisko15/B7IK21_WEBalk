package hu.me.iit.webalk.demo.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.me.iit.webalk.demo.Service.LicitService;

@RestController
@RequestMapping("/home")
public class LicitController {
	private final LicitService licitService;
	
	public LicitController(LicitService licitService) {
		super();
		this.licitService = licitService;
	}



	@GetMapping("/licit/highest")
	public int getHighest() {
		return licitService.getHighest();
	}
	
	@GetMapping("/licit/highest/{userId}")
	public int getHighestForUser(@PathVariable int userId) {
		return licitService.getHighestForUser(userId);
	}
	
	@PostMapping(consumes = "application/json")
	public void saveNewLicit(@Valid @RequestBody SaveLicitDto savelicitDto) {
		licitService.saveNewLicit(savelicitDto.getLicit(), savelicitDto.getUserId());
	}
	
	
}
