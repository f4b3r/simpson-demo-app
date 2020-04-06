package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Phrase;
import com.example.demo.service.PhraseService;

@RestController
@RequestMapping("phrase")
public class PhraseController {
	@Autowired
	PhraseService phraseService;
	
	@GetMapping("/find/{id}")
	public Iterable<Phrase> findByCharacterId( @PathVariable("id") String  id) {
		return phraseService.findByCharacterId(id);
			
	}

}
