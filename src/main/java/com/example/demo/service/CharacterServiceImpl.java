package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	

}
