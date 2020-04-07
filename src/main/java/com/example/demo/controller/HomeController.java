package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.SearchCharacterFilter;
import com.example.demo.domain.SimpsonCharacter;

@Controller
public class HomeController {

	 @RequestMapping(value = {
		        "",
		        "/home"  })
	public String home(Map<String, Object> model) {
		model.put("characters", new ArrayList<SimpsonCharacter>());
		model.put("searchFilter", new SearchCharacterFilter());
		return "home";
	}

}