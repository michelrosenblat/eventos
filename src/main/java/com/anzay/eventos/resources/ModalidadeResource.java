package com.anzay.eventos.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anzay.eventos.domain.Modalidade;

@RestController
@RequestMapping(value="/modalidades")
public class ModalidadeResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Modalidade> listar() {

		Modalidade mod1 = new Modalidade(1, "Dança Esportiva Standard");
		Modalidade mod2 = new Modalidade(2, "Dança Esportiva Latin");
		Modalidade mod3 = new Modalidade(3, "Dança de Salão");

		List<Modalidade> lista = new ArrayList<>();
		
		lista.add(mod1);
		lista.add(mod2);
		lista.add(mod3);
		
		return lista;
	}
	
}
