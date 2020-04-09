package com.example.demo.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.DataOperationException;
import com.example.demo.domain.Phrase;
import com.example.demo.domain.SearchCharacterFilter;
import com.example.demo.service.PhraseService;

@RestController
@RequestMapping("phrase")
public class PhraseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PhraseController.class);

	@Autowired
	PhraseService phraseService;

	@GetMapping("/find/{id}")
	public Iterable<Phrase> findByCharacterId(@PathVariable("id") String id) {
		return phraseService.findByCharacterId(id);

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void savePhrase(@ModelAttribute("phrase") Phrase phrase) throws DataOperationException {
		LOGGER.debug("Saving new phrase {} for  character id:{} ", phrase.getPhrase(), phrase.getCharacter());
		try {
			phraseService.save(new Phrase(UUID.randomUUID().toString(), phrase.getCharacter(), phrase.getPhrase()));
		} catch (Exception e) {
			LOGGER.error("Error saving phrase..");
			throw new DataOperationException(e.getMessage());
		}

	}
}
