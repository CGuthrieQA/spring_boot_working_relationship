package com.qa.barn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.barn.dto.AnimalDto;
import com.qa.barn.persistance.domain.Animal;
import com.qa.barn.service.AnimalService;

@RestController
@CrossOrigin
@RequestMapping("/animal")
public class AnimalController {

	private AnimalService service;
	
	// private BarnService barnService;

	// constructor
	@Autowired
	public AnimalController(AnimalService service) {
		super();
		this.service = service;
	}

	// CREATE

	// post
	@PostMapping("/create")
	public ResponseEntity<AnimalDto> create(@RequestBody Animal animal) {
		AnimalDto created = this.service.create(animal);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

	// READ

	// get
	@GetMapping("/read")
	public ResponseEntity<List<AnimalDto>> readAll() {
		return ResponseEntity.ok(this.service.readAll());
	}

	// get by id
	@GetMapping("/read/{id}")
	public ResponseEntity<AnimalDto> readById(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.readById(id));
	}

	// UPDATE

	// put by id
	@PutMapping("/update/{id}")
	public ResponseEntity<AnimalDto> update(@PathVariable Long id, @RequestBody AnimalDto animalDto) {
		return new ResponseEntity<>(this.service.update(animalDto, id), HttpStatus.ACCEPTED);
	}

	// patch by id

	// DELETE

	// delete by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<AnimalDto> delete(@PathVariable Long id) {
		return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
