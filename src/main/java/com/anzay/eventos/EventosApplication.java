package com.anzay.eventos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anzay.eventos.domain.Estilo;
import com.anzay.eventos.domain.Modalidade;
import com.anzay.eventos.repositories.EstiloRepository;
import com.anzay.eventos.repositories.ModalidadeRepository;

@SpringBootApplication
public class EventosApplication implements CommandLineRunner {

	@Autowired
	private ModalidadeRepository modalidadeRepository;
	
	@Autowired
	private EstiloRepository estiloRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EventosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Estilo est1 = new Estilo( null, "Waltz");
		Estilo est2 = new Estilo( null, "Tango");
		Estilo est3 = new Estilo( null, "Quickstep");

		Estilo est4 = new Estilo( null, "Rumba");
		Estilo est5 = new Estilo( null, "Cha-Cha-Cha");
		Estilo est6 = new Estilo( null, "Jive");	
		
		Modalidade mod1 = new Modalidade( null, "Standard");
		Modalidade mod2 = new Modalidade( null, "Latin");
	
		mod1.getEstilo().addAll(Arrays.asList(est1, est2, est3));
		mod2.getEstilo().addAll(Arrays.asList(est4, est5, est6));

		est1.getModalidades().addAll(Arrays.asList(mod1));
		est2.getModalidades().addAll(Arrays.asList(mod1));
		est3.getModalidades().addAll(Arrays.asList(mod1));
		est4.getModalidades().addAll(Arrays.asList(mod2));
		est5.getModalidades().addAll(Arrays.asList(mod2));
		est6.getModalidades().addAll(Arrays.asList(mod2));
		
		modalidadeRepository.saveAll(Arrays.asList(mod1, mod2));

		estiloRepository.saveAll(Arrays.asList(est1, est2, est3, est4, est5, est6));
	}

}
