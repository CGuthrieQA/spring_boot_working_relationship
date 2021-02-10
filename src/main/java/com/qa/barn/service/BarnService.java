package com.qa.barn.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.barn.dto.BarnDto;
import com.qa.barn.exceptions.BarnNotFoundException;
import com.qa.barn.persistance.domain.Barn;
import com.qa.barn.persistance.repo.BarnRepo;
import com.qa.barn.utils.BarnUtil;

@Service
public class BarnService {
	
	private BarnRepo repo;
	
	private ModelMapper mapper;
	
	// map to DTO
	private BarnDto mapToDTO(Barn barn) {
		return this.mapper.map(barn, BarnDto.class);
	}
	
	// constructor
	@Autowired
	public BarnService(BarnRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	// CREATE
	public BarnDto create(Barn barn) {
		return this.mapToDTO(this.repo.save(barn));
	}
	
	// READ ALL
	public List<BarnDto> readAll() {
		return this.repo.findAll()
				.stream() // stream returns a sequential stream of data considering the collection as source
				.map( // used to map an element to it's corresponding result
						this::mapToDTO // :: shorthand is forEach (enhanced for loop)
				)
				.collect(
						Collectors.toList() // used to return a list or string ( a list here )
				);	
	}
	
	// READ by id
	public BarnDto readById(Long id) {
		return this.mapToDTO(this.repo.findById(id).orElseThrow(BarnNotFoundException::new)); // need the optional throw in case of error
	}
	
	// UPDATE by id
	public BarnDto update(BarnDto barnDto, Long id) {
		// check if the record exists
		Barn toUpdate = this.repo.findById(id).orElseThrow(BarnNotFoundException::new);
		// set the record to update
		toUpdate.setName(barnDto.getName());
		// check during the update for any nulls
		BarnUtil.mergeNotNull(barnDto, toUpdate);
		// return the method from the repository
		return this.mapToDTO(this.repo.save(toUpdate));
		
	}

	// DELETE by id
	public boolean delete(Long id) {
		this.repo.deleteById(id); // deletes item by id
		return !this.repo.existsById(id);
	}
	
	
	// custom methods
	
	public List<BarnDto> findByColour(String colour){
		// similar to read method
		return this.repo.findByColour(colour).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	public List<BarnDto> findByName(String name){
		// similar to read method
		return this.repo.findByName(name).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
}
