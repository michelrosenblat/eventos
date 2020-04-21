package com.anzay.eventos.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/modalidades")
public class ModalidadeResource {

	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "REST está ok";
	}
	
}
