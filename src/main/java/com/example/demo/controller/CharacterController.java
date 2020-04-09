package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.DataOperationException;
import com.example.demo.domain.Phrase;
import com.example.demo.domain.SearchCharacterFilter;
import com.example.demo.service.CharacterService;

@Controller
@RequestMapping("/character")
public class CharacterController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CharacterController.class);

	@Autowired
	private CharacterService characterService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Map<String, Object> model) {
		model.put("searchFilter", new SearchCharacterFilter());
		model.put("phrase", new Phrase());
		model.put("characters", characterService.list());
		return "home";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(Map<String, Object> model, @ModelAttribute("searchFilter") SearchCharacterFilter filter) {
		model.put("characters", characterService.search(filter));
		return "home";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteTask(@PathVariable("id") String id, HttpServletResponse response) throws DataOperationException {
		LOGGER.debug("CALLING DELETE character on ID:" + id);
		try {
			characterService.delete(id);
		} catch (Exception ex) {
			LOGGER.error("ERROR ON DELETE CHARACTHER ID: {}",id + ex.getMessage());
			throw new DataOperationException(ex.getMessage());
		}
		LOGGER.debug("DELETED character with ID:" + id);
		return "redirect:/character/list";

	}

}
