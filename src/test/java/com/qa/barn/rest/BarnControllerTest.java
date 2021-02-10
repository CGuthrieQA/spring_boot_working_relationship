package com.qa.barn.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.qa.barn.controller.BarnController;
import com.qa.barn.dto.BarnDto;
import com.qa.barn.persistance.domain.Barn;
import com.qa.barn.service.BarnService;

@SpringBootTest // lets spring know this is a test class
@ActiveProfiles("dev") // which application profile are we testing on
public class BarnControllerTest {

	@Autowired
	private BarnController controller;
	
	// mock what it calls
	@MockBean
	private BarnService service;
	
	@Autowired
	private ModelMapper mapper;
	
	// map to DTO
	private BarnDto mapToDTO(Barn barn) {
		return this.mapper.map(barn, BarnDto.class);
	}
	
	// during our tests
	// here we can create some dummy objects
	// that we can use later
	
	
	// final so only usable in this class
	private final Barn TEST_BARN_1 = new Barn(1L, "red", 249.23D, "cambridge");
	private final Barn TEST_BARN_2 = new Barn(2L, "blue", 378.84D, "london");
	private final Barn TEST_BARN_3 = new Barn(3L, "green", 120.17D, "manchester");
	private final Barn TEST_BARN_4 = new Barn(4L, "yellow", 872.11D, "birmingham");
	
	private final List<Barn> LISTOFBARNS = List.of(TEST_BARN_1, TEST_BARN_2, TEST_BARN_3, TEST_BARN_4);
	
	@Test
	void createTest() throws Exception {
		when(this.service.create(TEST_BARN_1)).thenReturn(this.mapToDTO(TEST_BARN_1));
		assertThat(new ResponseEntity<BarnDto>(this.mapToDTO(TEST_BARN_1), HttpStatus.CREATED))
			.isEqualTo(this.controller.create(TEST_BARN_1));
		verify(this.service, atLeastOnce()).create(TEST_BARN_1);
	}

}