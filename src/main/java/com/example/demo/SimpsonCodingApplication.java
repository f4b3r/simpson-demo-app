package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Phrase;
import com.example.demo.domain.SimpsonCharacter;
import com.example.demo.service.CharacterService;
import com.example.demo.service.PhraseService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SimpsonCodingApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimpsonCodingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SimpsonCodingApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CharacterService characterService,PhraseService phraseService) {
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<SimpsonCharacter>> typeReference = new TypeReference<List<SimpsonCharacter>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/characters.json");

			// save characters
			try {
				List<SimpsonCharacter> characters = mapper.readValue(inputStream, typeReference);
				characterService.saveAll(characters);
				LOGGER.debug("characters Saved!");
			} catch (IOException e) {
				LOGGER.error("Unable to save characters: " + e.getMessage());
			}
			// save phrases
			TypeReference<List<Phrase>> phraseTypeReference = new TypeReference<List<Phrase>>() {
			};
			inputStream = TypeReference.class.getResourceAsStream("/json/phrases.json");

			try {
				List<Phrase> phrases = mapper.readValue(inputStream, phraseTypeReference);
				phraseService.saveAll(phrases);
				LOGGER.debug("phrases Saved!");
			} catch (IOException e) {
				LOGGER.error("Unable to save phrases: " + e.getMessage());
			}
		};
	}

}
