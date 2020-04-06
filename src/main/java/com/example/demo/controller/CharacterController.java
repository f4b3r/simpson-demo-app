package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.SearchCharacterFilter;
import com.example.demo.service.CharacterService;

@Controller
@RequestMapping("/character")
public class CharacterController {

	@Autowired
	private CharacterService characterService;

	@RequestMapping(value = "/list",  method = RequestMethod.GET)
	public String list(Map<String, Object> model) {
		model.put("searchFilter", new SearchCharacterFilter());
		model.put("characters", characterService.list());
		return "home";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(Map<String, Object> model,@ModelAttribute("searchFilter") SearchCharacterFilter filter) {
		model.put("characters", characterService.search(filter));
		return "home";
	}
	
}
