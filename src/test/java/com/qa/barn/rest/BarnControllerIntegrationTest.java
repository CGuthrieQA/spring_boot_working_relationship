package com.qa.barn.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.barn.dto.BarnDto;
import com.qa.barn.persistance.domain.Barn;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
// add SQL to use for testing
@Sql(scripts = { "classpath:Barn-schema.sql","classpath:Barn-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class BarnControllerIntegrationTest {
	
	// mock the MVC
	@Autowired
	private MockMvc mvc;
	
	// need something to generate JSON response (name this whatever)
	@Autowired
	private ObjectMapper jsonifier;
	
	@Autowired
	private ModelMapper mapper;
	
	// map to DTO
	private BarnDto mapToDTO(Barn barn) {
		return this.mapper.map(barn, BarnDto.class);
	}
	
	// final so only usable in this class
	private final Barn TEST_BARN_1 = new Barn(1L, "red", 249.23D, "cambridge");
	private final Barn TEST_BARN_2 = new Barn(2L, "blue", 378.84D, "london");
	private final Barn TEST_BARN_3 = new Barn(3L, "green", 120.17D, "manchester");
	private final Barn TEST_BARN_4 = new Barn(4L, "yellow", 872.11D, "birmingham");
	
	private final List<Barn> LISTOFBARNS = List.of(TEST_BARN_1, TEST_BARN_2, TEST_BARN_3, TEST_BARN_4);
	
	// stuff in here
	
	private final String URI = "/barn";
	
	@Test
	void createTest() throws Exception {
		// BarnDto testDto = mapToDTO(TEST_BARN_1);
		BarnDto testDto = mapToDTO(new Barn("red", 249.23D, "cambridge")); // take a barn
		// make it a string of JSON
		String testDTOAsJSON = this.jsonifier.writeValueAsString(testDto);
		
		// media query (path we use to create in this case
		// use a request builder
		RequestBuilder request = MockMvcRequestBuilders.post(URI + "/create").contentType(MediaType.APPLICATION_JSON).content(testDTOAsJSON);
				
		// check request
		ResultMatcher checkStatus = status().isCreated();
		
		// what to test against
		BarnDto testSavedDto = mapToDTO(new Barn("red", 249.23D, "cambridge"));
		
		// set id to next free id
		testSavedDto.setId(5L);
		// convert it into a JSON string
		String TesstSavedDtoAsJson = this.jsonifier.writeValueAsString(testSavedDto);
		
		// check if it matches
		ResultMatcher checkBody = MockMvcResultMatchers.content().json(TesstSavedDtoAsJson);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
}
