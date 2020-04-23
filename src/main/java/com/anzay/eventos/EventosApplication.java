package com.anzay.eventos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anzay.eventos.domain.Classe;
import com.anzay.eventos.domain.Endereco;
import com.anzay.eventos.domain.Estilo;
import com.anzay.eventos.domain.FaixaEtaria;
import com.anzay.eventos.domain.Modalidade;
import com.anzay.eventos.domain.Pessoa;
import com.anzay.eventos.domain.TipoParticipante;
import com.anzay.eventos.domain.enums.TipoDocumento;
import com.anzay.eventos.domain.enums.TipoPessoa;
import com.anzay.eventos.repositories.ClasseRepository;
import com.anzay.eventos.repositories.EnderecoRepository;
import com.anzay.eventos.repositories.EstiloRepository;
import com.anzay.eventos.repositories.FaixaEtariaRepository;
import com.anzay.eventos.repositories.ModalidadeRepository;
import com.anzay.eventos.repositories.PessoaRepository;
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
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClasseRepository classeRepository;
	
		
	
	
	public static void main(String[] args) {
		SpringApplication.run(EventosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		// CARGA NO BANDO DE DADOS
		
		// ############################################################################
		//
		//	MODALIDADES E ESTILOS
		//
		
		// -------------------------------
		// DANÇA ESPORTIVA
		// -------------------------------

		// Cria Modalidades
		Modalidade modStd = new Modalidade( null, "Standard");
		Modalidade modLat = new Modalidade( null, "Latin");

		// Cria Estilos
		Estilo std1 = new Estilo( null, "Waltz");
		Estilo std2 = new Estilo( null, "Tango");
		Estilo std3 = new Estilo( null, "Viennese Waltz");
		Estilo std4 = new Estilo( null, "Slow Foxtrot");
		Estilo std5 = new Estilo( null, "Quickstep");
		Estilo lat1 = new Estilo( null, "Samba");
		Estilo lat2 = new Estilo( null, "Cha-Cha-Cha");
		Estilo lat3 = new Estilo( null, "Rumba");
		Estilo lat4 = new Estilo( null, "Paso Doble");
		Estilo lat5 = new Estilo( null, "Jive");	

		Classe cls1 = new Classe(null, "A");
		Classe cls2 = new Classe(null, "B");
		Classe cls3 = new Classe(null, "C");
		Classe cls4 = new Classe(null, "D");
		Classe cls5 = new Classe(null, "E");
		Classe cls6 = new Classe(null, "F");

		Classe cls7 = new Classe(null, "A");
		Classe cls8 = new Classe(null, "B");
		Classe cls9 = new Classe(null, "C");
		Classe cls10 = new Classe(null, "D");
		Classe cls11 = new Classe(null, "E");
		Classe cls12 = new Classe(null, "F");

		// ASSOCIAÇÕES Modalidades e Estilos - Standard e Latin

		// Insere Estilos nas Modalidades
		modStd.getEstilo().addAll(Arrays.asList(std1, std2, std3, std4, std5));
		modLat.getEstilo().addAll(Arrays.asList(lat1, lat2, lat3, lat4, lat5));
		
		// Insere as Modalidades nos Estilos
		std1.getModalidades().addAll(Arrays.asList( modStd ));
		std2.getModalidades().addAll(Arrays.asList( modStd ));
		std3.getModalidades().addAll(Arrays.asList( modStd ));
		std4.getModalidades().addAll(Arrays.asList( modStd ));
		std5.getModalidades().addAll(Arrays.asList( modStd ));
		lat1.getModalidades().addAll(Arrays.asList( modLat ));
		lat2.getModalidades().addAll(Arrays.asList( modLat ));
		lat3.getModalidades().addAll(Arrays.asList( modLat ));
		lat4.getModalidades().addAll(Arrays.asList( modLat ));
		lat5.getModalidades().addAll(Arrays.asList( modLat ));

		// ASSOCIAÇÕES Modalidades e Classes

		// Insere Classes nas Modalidades
		modStd.getClasse().addAll(Arrays.asList(cls1, cls2, cls3, cls4, cls5, cls6));
		modLat.getClasse().addAll(Arrays.asList(cls7, cls8, cls9, cls10, cls11, cls12));
		
		// Insere as Modalidades nas Classes
		cls1.getModalidades().addAll(Arrays.asList( modStd ));
		cls2.getModalidades().addAll(Arrays.asList( modStd ));
		cls3.getModalidades().addAll(Arrays.asList( modStd ));
		cls4.getModalidades().addAll(Arrays.asList( modStd ));
		cls5.getModalidades().addAll(Arrays.asList( modStd ));
		cls6.getModalidades().addAll(Arrays.asList( modStd ));
		cls7.getModalidades().addAll(Arrays.asList( modLat ));
		cls8.getModalidades().addAll(Arrays.asList( modLat ));
		cls9.getModalidades().addAll(Arrays.asList( modLat ));
		cls10.getModalidades().addAll(Arrays.asList( modLat ));
		cls11.getModalidades().addAll(Arrays.asList( modLat ));
		cls12.getModalidades().addAll(Arrays.asList( modLat ));

		// Salva 
		modalidadeRepository.saveAll(Arrays.asList(modStd, modLat));

		estiloRepository.saveAll(Arrays.asList(std1, std2, std3, std4, std5));
		
		estiloRepository.saveAll(Arrays.asList(lat1, lat2, lat3, lat4, lat5));

		classeRepository.saveAll(Arrays.asList(cls1, cls2, cls3, cls4, cls5, cls6));
		classeRepository.saveAll(Arrays.asList(cls7, cls8, cls9, cls10, cls11, cls12));
		
		// -------------------------------
		// DANÇA DE SALÃO
		// -------------------------------
				
		// Cria os Estilos
		Estilo sal1 = new Estilo( null, "Bachata");	
		Estilo sal2 = new Estilo( null, "Bolero");
		Estilo sal3 = new Estilo( null, "Forró");
		Estilo sal4 = new Estilo( null, "Gafieira");
		Estilo sal5 = new Estilo( null, "Sertanejo");
		Estilo sal6 = new Estilo( null, "Salsa");	
		Estilo sal7 = new Estilo( null, "Samba-Rock");
		Estilo sal8 = new Estilo( null, "Tango");
		Estilo sal9 = new Estilo( null, "Zouk");	
		
		// Cria a Modalidade
		Modalidade modSal = new Modalidade( null, "Dança de Salão");

		
		// ASSOCIAÇÕES Modalidades e Estilos - Dança de Salão
		
		// Insere os estilos na modalidade 
		modSal.getEstilo().addAll(Arrays.asList(sal1, sal2, sal3, sal4, sal5, sal6, sal7, sal8, sal9));

		// Insere a modalidade nos estilos
		sal1.getModalidades().addAll(Arrays.asList(modSal));
		sal2.getModalidades().addAll(Arrays.asList(modSal));
		sal3.getModalidades().addAll(Arrays.asList(modSal));
		sal4.getModalidades().addAll(Arrays.asList(modSal));
		sal5.getModalidades().addAll(Arrays.asList(modSal));
		sal6.getModalidades().addAll(Arrays.asList(modSal));
		sal7.getModalidades().addAll(Arrays.asList(modSal));
		sal8.getModalidades().addAll(Arrays.asList(modSal));
		sal9.getModalidades().addAll(Arrays.asList(modSal));

		// Salva 
		modalidadeRepository.saveAll(Arrays.asList(modSal));

		estiloRepository.saveAll(Arrays.asList(sal1, sal2, sal3, sal4, sal5));
		estiloRepository.saveAll(Arrays.asList(sal6, sal7, sal8, sal9));
		

		// ############################################################################
		//
		//  TIPOS DE PARTICIPANTES
		//
				
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
		
		// ############################################################################
		//
		//  PESSOAS
		//

		//Pessoa p1 = new Pessoa(null, "Michel Rosenblat", TipoDocumento.CPF, "09283639880",   )
				
		Pessoa p1 = new Pessoa(null, "Michel Rosenblat", "09283639880", TipoDocumento.CPF, TipoPessoa.PESSOAFISICA, "994313232", "michelrosenblat@gmail.com");

		Endereco e1 = new Endereco(null,  "Rua Conselheiro Furtado", "1003", "Sala 02", "Liberdade", "São Paulo", "SP", "Brasil", "01003001", p1);
		Endereco e2 = new Endereco(null,  "Rua Osaka", "113", null, "Jardim Japão", "São Paulo", "SP", "Brasil", "01003001", p1);
		
		
		p1.getEnderecos().add(e1);
		p1.getEnderecos().add(e2);

		pessoaRepository.saveAll(Arrays.asList(p1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

	}

}
