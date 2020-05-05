package com.anzay.eventos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anzay.eventos.domain.TipoParticipante;
import com.anzay.eventos.repositories.TipoParticipanteRepository;
import com.anzay.eventos.services.exceptions.ObjectNotFoundException;


@Service
public class TipoParticipanteService {
	
	@Autowired
	private TipoParticipanteRepository repo;
	
	public TipoParticipante find(Integer id) {
		
		Optional<TipoParticipante> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + 
				" - Tipo: " + TipoParticipante.class.getName()) );
		
	}
	
	public TipoParticipante insert(TipoParticipante obj) {
		
		obj.setId(null);
		
		return repo.save(obj);
		
	}
	
	public TipoParticipante update(TipoParticipante obj) {
		
		find(obj.getId());
		return repo.save(obj);
		
	}
} 