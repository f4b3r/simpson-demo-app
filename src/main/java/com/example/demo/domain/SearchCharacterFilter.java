package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCharacterFilter {
	
	
	
	
	private String firstName;
	private String lastName;
	private Integer ageFrom;
	private Integer ageTo;

}
