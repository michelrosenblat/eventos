package com.anzay.eventos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anzay.eventos.domain.Competicao;
import com.anzay.eventos.repositories.CompeticaoRepository;
import com.anzay.eventos.services.exceptions.ObjectNotFoundException;


@Service
public class CompeticaoService {
	
	@Autowired
	private CompeticaoRepository repo;
	
	public Competicao find(Integer id) {
		
		Optional<Competicao> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + 
				" - Tipo: " + Competicao.class.getName()) );
		
	}

} 