package hu.me.iit.miskolc.webalk.db;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import hu.me.iit.miskolc.webalk.db.repository.People;
import hu.me.iit.miskolc.webalk.db.repository.PeopleRepository;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class PeopleControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	@Test
	public void schouldNoMainPage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().is4xxClientError());
	}
	
	@Test
	public void schouldReturnPeoples() throws Exception {
		//GIVEN
		People people = new People(1L, 12, "1");
		Iterable<People> all = peopleRepository.findAll();
		peopleRepository.save(people);
		
		//WHEN THEN
		this.mockMvc.perform(get("/people")).andDo(print()).andExpect(jsonPath("$.[0].name", is("1"))).andExpect(jsonPath("$.[0].age", is(12)));
	}
	
	@Test
	public void schouldReturnPeoples2() throws Exception {
		//GIVEN
		People people = new People(1L, 22, "2");
		Iterable<People> all = peopleRepository.findAll();
		peopleRepository.save(people);
		
		//WHEN THEN 
		this.mockMvc.perform(get("/people")).andDo(print()).andExpect(jsonPath("$.[0].name", is("2"))).andExpect(jsonPath("$.[0].age", is(22)));
	}


}
