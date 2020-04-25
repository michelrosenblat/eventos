package com.anzay.eventos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anzay.eventos.domain.Competidor;
import com.anzay.eventos.services.CompetidorService;

@RestController
@RequestMapping(value="/competidores")
public class CompetidorResource {

	@Autowired
	private CompetidorService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Competidor obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
}
