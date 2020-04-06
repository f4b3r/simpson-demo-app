package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.SearchCharacterFilter;
import com.example.demo.domain.SimpsonCharacter;


public interface CharacterService {

	public Iterable<SimpsonCharacter> list();

	public void saveAll(List<SimpsonCharacter> character);
	
	public SimpsonCharacter save(SimpsonCharacter character);
	
	public Iterable<SimpsonCharacter> search(SearchCharacterFilter filter);
	
}
