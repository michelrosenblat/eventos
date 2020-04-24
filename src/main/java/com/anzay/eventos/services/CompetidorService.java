package com.anzay.eventos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anzay.eventos.domain.Competidor;
import com.anzay.eventos.repositories.CompetidorRepository;
import com.anzay.eventos.services.exceptions.ObjectNotFoundException;


@Service
public class CompetidorService {
	
	@Autowired
	private CompetidorRepository repo;
	
	public Competidor buscar(Integer id) {
		
		Optional<Competidor> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + 
				" - Tipo: " + Competidor.class.getName()) );
		
	}

} 