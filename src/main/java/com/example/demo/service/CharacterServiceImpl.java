package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.SearchCharacterFilter;
import com.example.demo.domain.SimpsonCharacter;
import com.example.demo.repository.CharacterRepository;

@Service
public class CharacterServiceImpl implements CharacterService {

	@Autowired
	private CharacterRepository characterRepository;

	public Iterable<SimpsonCharacter> list() {
		return characterRepository.findAll();
	}

	public void saveAll(List<SimpsonCharacter> character) {
		characterRepository.saveAll(character);
	}

	@Override
	public Iterable<SimpsonCharacter> search(SearchCharacterFilter filter) {

		return characterRepository.findCharByNameSurnameAge(filter.getFirstName().toUpperCase(), filter.getLastName().toUpperCase(),
				filter.getAgeFrom(), filter.getAgeTo());
	}

	@Override
	public SimpsonCharacter save(SimpsonCharacter character) {
		return characterRepository.save(character);
		
	}

	@Override
	public void delete(String id) throws IllegalArgumentException{
		characterRepository.deleteById(id);
		
	}

	

}
