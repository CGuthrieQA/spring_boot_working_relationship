package com.qa.barn.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.barn.persistance.domain.Animal;

@Repository
public interface AnimalRepo  extends JpaRepository<Animal, Long> {

		//List<Animal> findByBarn(Barn barn);
	
}
