package com.anzay.eventos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anzay.eventos.domain.Modalidade;
import com.anzay.eventos.repositories.ModalidadeRepository;

@Service
public class ModalidadeService {
	
	@Autowired
	private ModalidadeRepository repo;
	
	public Modalidade buscar(Integer id) {
		
		Optional<Modalidade> obj = repo.findById(id);
		
		return obj.orElse(null);
		
	}

} 