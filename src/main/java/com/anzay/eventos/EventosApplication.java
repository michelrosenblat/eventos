package com.anzay.eventos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anzay.eventos.domain.Arbitro;
import com.anzay.eventos.domain.Classe;
import com.anzay.eventos.domain.Competidor;
import com.anzay.eventos.domain.Dancarino;
import com.anzay.eventos.domain.Endereco;
import com.anzay.eventos.domain.Estilo;
import com.anzay.eventos.domain.FaixaEtaria;
import com.anzay.eventos.domain.Formato;
import com.anzay.eventos.domain.Modalidade;
import com.anzay.eventos.domain.Pessoa;
import com.anzay.eventos.domain.TipoParticipante;
import com.anzay.eventos.domain.enums.Sexo;
import com.anzay.eventos.domain.enums.TipoDocumento;
import com.anzay.eventos.domain.enums.TipoPessoa;
import com.anzay.eventos.repositories.ArbitroRepository;
import com.anzay.eventos.repositories.ClasseRepository;
import com.anzay.eventos.repositories.CompetidorRepository;
import com.anzay.eventos.repositories.DancarinoRepository;
import com.anzay.eventos.repositories.EnderecoRepository;
import com.anzay.eventos.repositories.EstiloRepository;
import com.anzay.eventos.repositories.FaixaEtariaRepository;
import com.anzay.eventos.repositories.FormatoRepository;
import com.anzay.eventos.repositories.ModalidadeRepository;
import com.anzay.eventos.repositories.PessoaRepository;
import com.anzay.eventos.repositories.TipoParticipanteRepository;

@SpringBootApplication
public class EventosApplication implements CommandLineRunner {

	@Autowired
	private ArbitroRepository arbitroRepository;
	
	@Autowired
	private ClasseRepository classeRepository;
	
	@Autowired
	private CompetidorRepository competidorRepository;
	
	@Autowired
	private DancarinoRepository dancarinoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EstiloRepository estiloRepository;
	
	@Autowired
	private FormatoRepository formatoRepository;
	
	@Autowired
	private FaixaEtariaRepository faixaEtariaRepository;
	
	@Autowired
	private ModalidadeRepository modalidadeRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private TipoParticipanteRepository tipoParticipanteRepository;
	
		
	
	
	public static void main(String[] args) {
		SpringApplication.run(EventosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		// ############################################################################
		//
		// CARGA NO BANDO DE DADOS
		//
		// ############################################################################


		// ----------------------------------------------------------------------------
		// PESSOA, DANÇARINO, COMPETIDOR, ÁRBITRO 
		// ----------------------------------------------------------------------------

		// PESSOA
		Pessoa pes1 = new Pessoa(null, "Michel", "12345678901", TipoDocumento.CPF, TipoPessoa.PESSOAFISICA, Sexo.MASCULINO,"5511911110001", "michelrosenblat@gmail.com");
		pessoaRepository.saveAll(Arrays.asList(pes1));
		
		// DANÇARINO 
		Dancarino dan1 = new Dancarino(null, "André Magro", "12345678902", TipoDocumento.CPF, TipoPessoa.PESSOAFISICA, Sexo.MASCULINO,"5511911110002", "michelrosenblat@gmail.com");

		// Enedereço do Dançarinio
		Endereco endDan1 = new Endereco(null, "Rua dos Dançarinos", "101", "Ap. 23", "Jardim Dançante", "Taubaté", "SP", "BRASIL", "19000001", dan1);

		dancarinoRepository.saveAll(Arrays.asList(dan1));
		enderecoRepository.saveAll(Arrays.asList(endDan1));
		
		// PARTICIPANTE 
		Competidor comp1 = new Competidor(null, "Flavio Nunes", "12345678955", TipoDocumento.CPF, TipoPessoa.PESSOAFISICA, Sexo.MASCULINO,"5511911110001", "michelrosenblat@gmail.com");
		Competidor comp2 = new Competidor(null, "Miki Anzai", "12345678956", TipoDocumento.CPF, TipoPessoa.PESSOAFISICA, Sexo.FEMININO,"5511911110002", "michelrosenblat@gmail.com");
		Competidor comp3 = new Competidor(null, "Maricelia Araújo", "12345678900", TipoDocumento.CPF, TipoPessoa.PESSOAFISICA, Sexo.FEMININO,"5511911110003", "michelrosenblat@gmail.com");

		// Enedereço dos Participantes
		Endereco endPart1 = new Endereco(null, "Rua dos Japoneses", "899", null, "Vila Nippon", "Sagamihara", "Kanagawa", "JAPÃO", "123456", comp1);
		Endereco endPart2 = new Endereco(null, "Rua dos Japonesas", "899", null, "Vila Nippon", "Sagamihara", "Kanagawa", "JAPÃO", "123456", comp2);
		Endereco endPart3 = new Endereco(null, "Avenida dos Atletas", "s/n", null, "Parque ESEF", "Jundiaí", "SP", "BRASIL", "12000005", comp3);

		competidorRepository.saveAll(Arrays.asList(comp1, comp2, comp3));
		enderecoRepository.saveAll(Arrays.asList(endPart1, endPart2, endPart3));

		
		// ÁRBITRO 
		Arbitro arb1 = new Arbitro(null, "Patric Tebaldi", "12345678901", TipoDocumento.CPF, TipoPessoa.PESSOAFISICA, Sexo.MASCULINO,"5511911110001", "michelrosenblat@gmail.com", "1234");
		arbitroRepository.saveAll(Arrays.asList(arb1));


		
		// ----------------------------------------------------------------------------
		// MODALIDADE, ESTILO, CLASSE, FAIXA ETÁRIA 
		// ----------------------------------------------------------------------------
		

		// MODALIDADE
		
		Modalidade modStd = new Modalidade( null, "Standard");
		Modalidade modLat = new Modalidade( null, "Latin");
		Modalidade modSal = new Modalidade( null, "Dança de Salão");


		// FAIXA ETÁRIA
		
		FaixaEtaria fe1  = new FaixaEtaria(null, "Livre"          , -1, -1);
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
		
		faixaEtariaRepository.saveAll(Arrays.asList(fe1, fe2, fe3, fe4, fe5, fe6, fe7, fe8, fe9, fe10, fe11, fe12, fe13, fe14, fe15, fe16));


		// TIPO PARTICIPANTE
		
		TipoParticipante tp1 = new TipoParticipante(null, "Casal", 2, 2);
		TipoParticipante tp2 = new TipoParticipante(null, "Solo", 2, 2);
		TipoParticipante tp3 = new TipoParticipante(null, "Grupo Coreográfico Pequeno", 3, 7);
		TipoParticipante tp4 = new TipoParticipante(null, "Grupo Coreográfico Grande", 8, 20);
		TipoParticipante tp5 = new TipoParticipante(null, "Time", 5, 5);
		TipoParticipante tp6 = new TipoParticipante(null, "Same Sex", 2, 2);
		
		tipoParticipanteRepository.saveAll(Arrays.asList(tp1, tp2, tp3, tp4, tp5, tp6));	
		

		// ESTILO
		
		Estilo estSt1 = new Estilo( null, "Waltz");
		Estilo estSt2 = new Estilo( null, "Tango");
		Estilo estSt3 = new Estilo( null, "Viennese Waltz");
		Estilo estSt4 = new Estilo( null, "Slow Foxtrot");
		Estilo estSt5 = new Estilo( null, "Quickstep");
		Estilo estLt1 = new Estilo( null, "Samba");
		Estilo estLt2 = new Estilo( null, "Cha-Cha-Cha");
		Estilo estLt3 = new Estilo( null, "Rumba");
		Estilo estLt4 = new Estilo( null, "Paso Doble");
		Estilo estLt5 = new Estilo( null, "Jive");	
		Estilo sal1 = new Estilo( null, "Bachata");	
		Estilo sal2 = new Estilo( null, "Bolero");
		Estilo sal3 = new Estilo( null, "Forró");
		Estilo sal4 = new Estilo( null, "Gafieira");
		Estilo sal5 = new Estilo( null, "Sertanejo");
		Estilo sal6 = new Estilo( null, "Salsa");	
		Estilo sal7 = new Estilo( null, "Samba-Rock");
		Estilo sal8 = new Estilo( null, "Tango");
		Estilo sal9 = new Estilo( null, "Zouk");	
		

		// CLASSE
		
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

		
		//---------------------------------------------------------------------------------------------
		// ASSOCIAÇÕES 
		//---------------------------------------------------------------------------------------------

		// ESTILOS E MODALIDADES
		
		// Insere Estilos nas Modalidades
		modStd.getEstilos().addAll(Arrays.asList(estSt1, estSt2, estSt3, estSt4, estSt5));
		modLat.getEstilos().addAll(Arrays.asList(estLt1, estLt2, estLt3, estLt4, estLt5));

		
		// Insere as Modalidades nos Estilos
		estSt1.getModalidades().addAll(Arrays.asList( modStd ));
		estSt2.getModalidades().addAll(Arrays.asList( modStd ));
		estSt3.getModalidades().addAll(Arrays.asList( modStd ));
		estSt4.getModalidades().addAll(Arrays.asList( modStd ));
		estSt5.getModalidades().addAll(Arrays.asList( modStd ));
		estLt1.getModalidades().addAll(Arrays.asList( modLat ));
		estLt2.getModalidades().addAll(Arrays.asList( modLat ));
		estLt3.getModalidades().addAll(Arrays.asList( modLat ));
		estLt4.getModalidades().addAll(Arrays.asList( modLat ));
		estLt5.getModalidades().addAll(Arrays.asList( modLat ));


		// CLASSES E MODALIDADES

		// Insere Classes nas Modalidades
		modStd.getClasses().addAll(Arrays.asList(cls1, cls2, cls3, cls4, cls5, cls6));
		modLat.getClasses().addAll(Arrays.asList(cls7, cls8, cls9, cls10, cls11, cls12));
		
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
		


		// ÁRBITRO E MODALIDADE
		
		// Insere Árbitro nas Modalidades
		modStd.getArbitros().addAll(Arrays.asList(arb1));
		modLat.getArbitros().addAll(Arrays.asList(arb1));
		modSal.getArbitros().addAll(Arrays.asList(arb1));
		
		// Insere as Modalidades nos Árbitros
		arb1.getModalidades().addAll(Arrays.asList( modStd, modLat, modSal ));

		
		// COMPETIDOR E MODALIDADE
		
		// Insere as Modalidades nos Competidores
		comp1.getModalidades().addAll(Arrays.asList( modStd, modLat));
		comp2.getModalidades().addAll(Arrays.asList( modStd, modLat));
		comp3.getModalidades().addAll(Arrays.asList( modStd, modLat, modSal ));

		// Insere Competidores nas Modalidades
		modStd.getCompetidores().addAll(Arrays.asList(comp1, comp2, comp3));
		modLat.getCompetidores().addAll(Arrays.asList(comp1, comp2, comp3));
		modSal.getCompetidores().addAll(Arrays.asList(comp3));


		// ----------------------------------------------------------------------------
		// PESSOA, DANÇARINO, COMPETIDOR, ÁRBITRO 
		// ----------------------------------------------------------------------------

		// FORMATO

		Formato fmt1 = new Formato(null, "Casal Standard Classe F Adulto", modStd, tp1);

		fmt1.getClasses().addAll(Arrays.asList(cls1));
		cls1.getFormatos().addAll(Arrays.asList(fmt1));
		
		fmt1.getFaixaEtarias().addAll(Arrays.asList(fe7));
		fe7.getFormatos().addAll(Arrays.asList(fmt1));
		
		fmt1.getEstilos().addAll(Arrays.asList(estSt1, estSt2, estSt3));
		estSt1.getFormatos().addAll(Arrays.asList(fmt1));
		estSt2.getFormatos().addAll(Arrays.asList(fmt1));
		estSt3.getFormatos().addAll(Arrays.asList(fmt1));
		
		
		// ----------------------------------------------------------------------------
		// COMMIT 
		// ----------------------------------------------------------------------------

		modalidadeRepository.saveAll(Arrays.asList(modStd, modLat, modSal));

		formatoRepository.saveAll(Arrays.asList(fmt1));

		faixaEtariaRepository.saveAll(Arrays.asList(fe1, fe2, fe3, fe4, fe5, fe6, fe7, fe8, fe9, fe10, fe11, fe12, fe13, fe14, fe15, fe16));

		estiloRepository.saveAll(Arrays.asList(estSt1, estSt2, estSt3, estSt4, estSt5,
				estLt1, estLt2, estLt3, estLt4, estLt5,
				sal1, sal2, sal3, sal4, sal5, sal6, sal7, sal8, sal9));

		classeRepository.saveAll(Arrays.asList(cls1, cls2, cls3, cls4, cls5, cls6, cls7, cls8, cls9, cls10, cls11, cls12));		
		
		arbitroRepository.saveAll(Arrays.asList(arb1));

		competidorRepository.saveAll(Arrays.asList(comp1, comp2, comp3));
		
		
	}

}
