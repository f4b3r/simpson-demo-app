package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Phrase;

public interface PhraseService {

	public void saveAll(List<Phrase> phrase);

	public Phrase findById(String id);

	public Iterable<Phrase> findByCharacterId(String id);

}
