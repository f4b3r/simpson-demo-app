package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Phrase;
import com.example.demo.domain.SimpsonCharacter;
import com.example.demo.service.CharacterService;
import com.example.demo.service.PhraseService;

@SpringBootTest
public class PhraseRepositoryTest {

	@Autowired
	private PhraseService service;

	@Autowired
	private CharacterService characterService;

	@Test
	public void testFindPhraseByCharacterID() throws Exception {
		Iterable<SimpsonCharacter> chars = characterService.list();

		assertNotNull(chars);
		SimpsonCharacter character = chars.iterator().next();
		Iterable<Phrase> phrases = service.findByCharacterId(character.get_id());
		Iterator<Phrase> iterator = phrases.iterator();
		while (iterator.hasNext()) {
			assertEquals(character.get_id(), iterator.next().getCharacter());
		}

	}
}
