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

import com.qa.barn.dto.BarnDto;
import com.qa.barn.persistance.domain.Barn;
import com.qa.barn.service.BarnService;

@RestController
@CrossOrigin
@RequestMapping("/barn")
public class BarnController {
	
	
	// import service
	private BarnService service;
	
	// constructor
	@Autowired
	public BarnController(BarnService service) {
		super();
		this.service = service;
	}
	
	// PathVariable - URL pattern matching
	// RequestBody - append data of message to body of the request
	
	
	// ResponseEntity<>
	// represents the WHOLE HTTP response status code, headers, even the body of the response.
	
	// CREATE
	
	// post
	@PostMapping("/create")
	public ResponseEntity<BarnDto> create(@RequestBody Barn barn){
		BarnDto created = this.service.create(barn);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	//READ
	
	// get
	@GetMapping("/read")
	public ResponseEntity<List<BarnDto>> readAll() {
		return ResponseEntity.ok(this.service.readAll());
	}
	
	// get by id
	@GetMapping("/read/{id}")
	public ResponseEntity<BarnDto> readById(@PathVariable Long id){
		return ResponseEntity.ok(this.service.readById(id));
	}
	
	// UPDATE
	
	// put by id
	@PutMapping("/update/{id}")
	public ResponseEntity<BarnDto> update(@PathVariable Long id, @RequestBody BarnDto barnDto) {
		return new ResponseEntity<>(this.service.update(barnDto, id), HttpStatus.ACCEPTED);
	}
	
	// patch by id
	
	
	// DELETE
	
	// delete by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<BarnDto> delete(@PathVariable Long id){
		return this.service.delete(id) ? 
				new ResponseEntity<>(HttpStatus.NO_CONTENT) 
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	// custom mappings
	
	@GetMapping("/colour/{colour}")
	public ResponseEntity<List<BarnDto>> findByColour(@PathVariable String colour){
		return ResponseEntity.ok(this.service.findByColour(colour));
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<BarnDto>> findByName(@PathVariable String name){
		return ResponseEntity.ok(this.service.findByName(name));
	}
}
