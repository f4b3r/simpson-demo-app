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




}