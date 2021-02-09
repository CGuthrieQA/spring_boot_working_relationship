package com.qa.barn.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.barn.dto.AnimalDto;
import com.qa.barn.persistance.domain.Animal;
import com.qa.barn.persistance.repo.AnimalRepo;
import com.qa.barn.utils.AnimalUtil;

@Service
public class AnimalService {
	
	private AnimalRepo repo;
	private ModelMapper mapper;
	
	
	// map to DTO
	private AnimalDto mapToDTO(Animal animal) {
		return this.mapper.map(animal, AnimalDto.class);
	}
		
	// constructor
	@Autowired
	public AnimalService(AnimalRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	
	// CREATE
		public AnimalDto create(Animal animal) {
			return this.mapToDTO(this.repo.save(animal));
		}
		
		// READ ALL
		public List<AnimalDto> readAll() {
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
		public AnimalDto readById(Long id) {
			return this.mapToDTO(this.repo.findById(id).orElseThrow()); // need the optional throw in case of error
		}
		
		// UPDATE by id
		public AnimalDto update(AnimalDto animalDto, Long id) {
			// check if the record exists
			Animal toUpdate = this.repo.findById(id).orElseThrow();
			// set the record to update
			toUpdate.setName(animalDto.getName());
			// check during the update for any nulls
			AnimalUtil.mergeNotNull(animalDto, toUpdate);
			// return the method from the repository
			return this.mapToDTO(this.repo.save(toUpdate));
			
		}

		// DELETE by id
		public boolean delete(Long id) {
			this.repo.deleteById(id); // deletes item by id
			return !this.repo.existsById(id);
		}
}
