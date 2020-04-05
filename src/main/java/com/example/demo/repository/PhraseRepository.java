package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Phrase;

public interface PhraseRepository extends CrudRepository<Phrase,String>{


}
