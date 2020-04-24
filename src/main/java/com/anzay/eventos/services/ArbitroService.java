package com.anzay.eventos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anzay.eventos.domain.Arbitro;
import com.anzay.eventos.repositories.ArbitroRepository;
import com.anzay.eventos.services.exceptions.ObjectNotFoundException;


@Service
public class ArbitroService {
	
	@Autowired
	private ArbitroRepository repo;
	
	public Arbitro buscar(Integer id) {
		
		Optional<Arbitro> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + 
				" - Tipo: " + Arbitro.class.getName()) );
		
	}

} 