package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.Phrase;

public interface PhraseRepository extends CrudRepository<Phrase,String>{

	@Query(value = "SELECT * FROM PHRASE ph WHERE ph.CHARACTER = :characterID", 
			  nativeQuery = true)
			Iterable<Phrase> findByCharacterId(
			  @Param("characterID") String characterID ); 
}
