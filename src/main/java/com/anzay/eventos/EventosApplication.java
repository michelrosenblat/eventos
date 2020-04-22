package com.anzay.eventos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anzay.eventos.domain.Estilo;
import com.anzay.eventos.domain.FaixaEtaria;
import com.anzay.eventos.domain.Modalidade;
import com.anzay.eventos.domain.TipoParticipante;
import com.anzay.eventos.repositories.EstiloRepository;
import com.anzay.eventos.repositories.FaixaEtariaRepository;
import com.anzay.eventos.repositories.ModalidadeRepository;
import com.anzay.eventos.repositories.TipoParticipanteRepository;

@SpringBootApplication
public class EventosApplication implements CommandLineRunner {

	@Autowired
	private ModalidadeRepository modalidadeRepository;
	
	@Autowired
	private EstiloRepository estiloRepository;
	
	@Autowired
	private FaixaEtariaRepository faixaEtariaRepository;
	
	@Autowired
	private TipoParticipanteRepository tipoParticipanteRepository;
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(EventosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// DANÇA ESPORTIVA STANDARD

		Modalidade std = new Modalidade( null, "Standard");
		Estilo std1 = new Estilo( null, "Waltz");
		Estilo std2 = new Estilo( null, "Tango");
		Estilo std3 = new Estilo( null, "Viennese Waltz");
		Estilo std4 = new Estilo( null, "Slow Foxtrot");
		Estilo std5 = new Estilo( null, "Quickstep");

		std.getEstilo().addAll(Arrays.asList(std1, std2, std3, std4, std5));
		
		std1.getModalidades().addAll(Arrays.asList(std));
		std2.getModalidades().addAll(Arrays.asList(std));
		std3.getModalidades().addAll(Arrays.asList(std));
		std4.getModalidades().addAll(Arrays.asList(std));
		std5.getModalidades().addAll(Arrays.asList(std));

		// DANÇA ESPORTIVA LATIN
		
		Modalidade lat = new Modalidade( null, "Latin");
		Estilo lat1 = new Estilo( null, "Samba");
		Estilo lat2 = new Estilo( null, "Cha-Cha-Cha");
		Estilo lat3 = new Estilo( null, "Rumba");
		Estilo lat4 = new Estilo( null, "Paso Doble");
		Estilo lat5 = new Estilo( null, "Jive");	
		
		lat.getEstilo().addAll(Arrays.asList(lat1, lat2, lat3, lat4, lat5));

		lat1.getModalidades().addAll(Arrays.asList(lat));
		lat2.getModalidades().addAll(Arrays.asList(lat));
		lat3.getModalidades().addAll(Arrays.asList(lat));
		lat4.getModalidades().addAll(Arrays.asList(lat));
		lat5.getModalidades().addAll(Arrays.asList(lat));

		
		// DANÇA DE SALÃO
		
		Estilo sal1 = new Estilo( null, "Bachata");	
		Estilo sal2 = new Estilo( null, "Bolero");
		Estilo sal3 = new Estilo( null, "Forró");
		Estilo sal4 = new Estilo( null, "Gafieira");
		Estilo sal5 = new Estilo( null, "Sertanejo");
		Estilo sal6 = new Estilo( null, "Salsa");	
		Estilo sal7 = new Estilo( null, "Samba-Rock");
		Estilo sal8 = new Estilo( null, "Tango");
		Estilo sal9 = new Estilo( null, "Zouk");	
		
		Modalidade sal = new Modalidade( null, "Dança de Salão");
		sal.getEstilo().addAll(Arrays.asList(sal1, sal2, sal3, sal4, sal5, 
											 sal6, sal7, sal8, sal9));

		sal1.getModalidades().addAll(Arrays.asList(sal));
		sal2.getModalidades().addAll(Arrays.asList(sal));
		sal3.getModalidades().addAll(Arrays.asList(sal));
		sal4.getModalidades().addAll(Arrays.asList(sal));
		sal5.getModalidades().addAll(Arrays.asList(sal));
		sal6.getModalidades().addAll(Arrays.asList(sal));
		sal7.getModalidades().addAll(Arrays.asList(sal));
		sal8.getModalidades().addAll(Arrays.asList(sal));
		sal9.getModalidades().addAll(Arrays.asList(sal));

		
		modalidadeRepository.saveAll(Arrays.asList(std, lat, sal));

		estiloRepository.saveAll(Arrays.asList(std1, std2, std3, std4, std5));
		estiloRepository.saveAll(Arrays.asList(lat1, lat2, lat3, lat4, lat5));
		estiloRepository.saveAll(Arrays.asList(sal1, sal2, sal3, sal4, sal5));
		estiloRepository.saveAll(Arrays.asList(sal6, sal7, sal8, sal9));

		
		TipoParticipante tp1 = new TipoParticipante(null, "Casal", 2, 2);
		TipoParticipante tp2 = new TipoParticipante(null, "Solo", 2, 2);
		TipoParticipante tp3 = new TipoParticipante(null, "Grupo Coreográfico Pequeno", 3, 7);
		TipoParticipante tp4 = new TipoParticipante(null, "Grupo Coreográfico Grande", 8, 20);
		TipoParticipante tp5 = new TipoParticipante(null, "Time", 5, 5);
		TipoParticipante tp6 = new TipoParticipante(null, "Same Sex", 2, 2);

		tipoParticipanteRepository.saveAll(Arrays.asList(tp1, tp2, tp3, tp4, tp5, tp6));

		FaixaEtaria fe1  = new FaixaEtaria(null, "Livre"     ,      -1, -1);
		FaixaEtaria fe2  = new FaixaEtaria(null, "Junior I"       ,  0, 9);
		FaixaEtaria fe3  = new FaixaEtaria(null, "Junior II"      , 10, 11);
		FaixaEtaria fe4  = new FaixaEtaria(null, "Juvenil I"      , 12, 13);
		FaixaEtaria fe5  = new FaixaEtaria(null, "Juvenil II"     , 14, 15);
		FaixaEtaria fe6  = new FaixaEtaria(null, "Youth"          , 16, 18);
		FaixaEtaria fe7  = new FaixaEtaria(null, "Adulto"         , 19, 34);
		FaixaEtaria fe8  = new FaixaEtaria(null, "Senior I"       , 35, 44);
		FaixaEtaria fe9  = new FaixaEtaria(null, "Senior II"      , 45, 54);
		FaixaEtaria fe10 = new FaixaEtaria(null, "Senior III"     , 55, 54);
		FaixaEtaria fe11 = new FaixaEtaria(null, "Senior IV"      , 65, -1);
		FaixaEtaria fe12 = new FaixaEtaria(null, "Crianças"       ,  0, 13);
		FaixaEtaria fe13 = new FaixaEtaria(null, "Juvenil"        , 14, 18);
		FaixaEtaria fe14 = new FaixaEtaria(null, "Adulto"         , 19, 34);
		FaixaEtaria fe15 = new FaixaEtaria(null, "Senior I e II"  , 35, 54);
		FaixaEtaria fe16 = new FaixaEtaria(null, "Senior III e IV", 45, -1);

		faixaEtariaRepository.saveAll(Arrays.asList(fe1, fe2, fe3, fe4, fe5, fe6, fe7, fe8, 
													fe9, fe10, fe11, fe12, fe13, fe14, fe15, fe16));
		
	}

}
