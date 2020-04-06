package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.SearchCharacterFilter;
import com.example.demo.domain.SimpsonCharacter;
import com.example.demo.service.CharacterService;

@Controller
public class HomeController {

	

	
	
	@RequestMapping("/home")
	public String home(Map<String, Object> model) {
		model.put("characters", new ArrayList<SimpsonCharacter>());
		model.put("searchFilter", new SearchCharacterFilter());
		return "home";
	}

	
}