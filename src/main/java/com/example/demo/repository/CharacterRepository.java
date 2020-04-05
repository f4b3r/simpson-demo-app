package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.SimpsonCharacter;

public interface CharacterRepository extends CrudRepository<SimpsonCharacter,String>{



}
