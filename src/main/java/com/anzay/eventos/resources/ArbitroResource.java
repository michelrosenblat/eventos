package com.anzay.eventos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anzay.eventos.domain.Arbitro;
import com.anzay.eventos.services.ArbitroService;

@RestController
@RequestMapping(value="/arbitros")
public class ArbitroResource {

	@Autowired
	private ArbitroService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Arbitro obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
}