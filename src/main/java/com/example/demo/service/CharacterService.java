package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.SimpsonCharacter;


public interface CharacterService {

	public Iterable<SimpsonCharacter> list();

	public void saveAll(List<SimpsonCharacter> character);
	
	
	
}
