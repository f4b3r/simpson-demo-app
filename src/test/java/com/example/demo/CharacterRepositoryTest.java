package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.SearchCharacterFilter;
import com.example.demo.domain.SimpsonCharacter;
import com.example.demo.service.CharacterService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class CharacterRepositoryTest {

	@Autowired
	CharacterService charService;
	
	private static String _ID = "abc";
	private static String FIRST_NAME = "testName";
	private static String LAST_NAME = "testLastName";
	private static String TEST_IMG = "testIMAGE";
	private static Integer AGE = 150;
	
	@BeforeAll
	 public  void saveCharacter() {
		SimpsonCharacter entity = new SimpsonCharacter(_ID, FIRST_NAME, LAST_NAME, TEST_IMG, AGE);
		
		assertNotNull(charService.save(entity));
    }
	
	@Test
	public void testSearchByFirstNameFilter() {
		SearchCharacterFilter  filter = new SearchCharacterFilter(FIRST_NAME, "",null,null);
		assertEquals(charService.search(filter).iterator().next().get_id(), _ID);
		
	}
	
	@Test
	public void testSearchByLastNameFilter() {
		SearchCharacterFilter  filter = new SearchCharacterFilter("", LAST_NAME,null,null);
		assertEquals(charService.search(filter).iterator().next().get_id(), _ID);
		
	}
	
	@Test
	public void testSearchByAgeFilter() {
		SearchCharacterFilter  filter = new SearchCharacterFilter("", "",140,151);
		assertEquals(charService.search(filter).iterator().next().get_id(), _ID);
		
	}
	
	@Test
	public void testSearchByAllFilter() {
		SearchCharacterFilter  filter = new SearchCharacterFilter(FIRST_NAME, LAST_NAME,140,151);
		assertEquals(charService.search(filter).iterator().next().get_id(), _ID);
		
	}
}
