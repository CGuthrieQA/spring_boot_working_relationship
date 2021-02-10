package com.qa.barn.persistance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.barn.persistance.domain.Barn;

@Repository
public interface BarnRepo extends JpaRepository<Barn, Long> {
	
	// any custom SQL we want we can have in here
	 //Optional<Barn> findById(Long id);
	
	@Query(value="SELECT * FROM BARN WHERE colour=?1", nativeQuery = true)
	List<Barn> findByColour(String colour);
	
	@Query(value="SELECT * FROM BARN WHERE name=?1", nativeQuery = true)
	List<Barn> findByName(String name);
	
}
