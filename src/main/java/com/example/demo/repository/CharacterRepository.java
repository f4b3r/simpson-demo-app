package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.SimpsonCharacter;

public interface CharacterRepository extends CrudRepository<SimpsonCharacter,String>{

	@Query(value = "SELECT * FROM SIMPSON_CHARACTER sc WHERE UPPER(sc.FIRST_NAME)"
			+ " LIKE CONCAT ('%',:firstName,'%') "
			+ "and UPPER(sc.LAST_NAME) LIKE CONCAT ('%',:lastName,'%')  and (:ageFrom is null or sc.AGE >= :ageFrom)"
			+ " and (:ageTo is null or sc.AGE <= :ageTo)", 
			  nativeQuery = true)
			Iterable<SimpsonCharacter> findCharByNameSurnameAge(
			  @Param("firstName") String firstName, @Param("lastName") String lastName,
			  @Param("ageFrom") Integer ageFrom, @Param("ageTo") Integer ageTo );

}
