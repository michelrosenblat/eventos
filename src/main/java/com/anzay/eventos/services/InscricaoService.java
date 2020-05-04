package com.anzay.eventos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anzay.eventos.domain.Inscricao;
import com.anzay.eventos.repositories.InscricaoRepository;
import com.anzay.eventos.services.exceptions.ObjectNotFoundException;


@Service
public class InscricaoService {
	
	@Autowired
	private InscricaoRepository repo;
	
	public Inscricao find(Integer id) {
		
		Optional<Inscricao> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + 
				" - Tipo: " + Inscricao.class.getName()) );
		
	}

} 