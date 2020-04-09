package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Phrase;
import com.example.demo.repository.PhraseRepository;
@Service
public class PhraseServiceImpl implements PhraseService{

	@Autowired
	private PhraseRepository phraseRepository;
	
	
	@Override
	public void saveAll(List<Phrase> phrase) {
		phraseRepository.saveAll(phrase);
		
	}


	@Override
	public Phrase findById(String id) {
		return 	phraseRepository.findById(id).get();
	}


	@Override
	public Iterable<Phrase> findByCharacterId(String id) {
		return phraseRepository.findByCharacterId(id);
	}


	@Override
	public void save(Phrase phrase) throws IllegalArgumentException{
		phraseRepository.save(phrase);		
	}




}
