package com.qa.barn.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.barn.persistance.domain.Barn;

@Repository
public interface BarnRepo extends JpaRepository<Barn, Long> {
	
	// any custom SQL we want we can have in here
	 //Optional<Barn> findById(Long id);
	
}
