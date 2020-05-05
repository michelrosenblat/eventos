package com.anzay.eventos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anzay.eventos.domain.Formato;
import com.anzay.eventos.repositories.FormatoRepository;
import com.anzay.eventos.services.exceptions.ObjectNotFoundException;


@Service
public class FormatoService {
	
	@Autowired
	private FormatoRepository repo;
	
	public Formato find(Integer id) {
		
		Optional<Formato> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + 
				" - Tipo: " + Formato.class.getName()) );
		
	}
	
	public Formato insert(Formato obj) {
		
		obj.setId(null);
		return repo.save(obj);
		
	}

	public Formato update(Formato obj) {
		
		find(obj.getId());
		return repo.save(obj);
		
	}
} 