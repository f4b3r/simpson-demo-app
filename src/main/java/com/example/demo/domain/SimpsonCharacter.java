package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SimpsonCharacter {


	@Id
	private String _id;
    private String firstName;
    private String lastName;
    private String picture;
    private int age;
}
