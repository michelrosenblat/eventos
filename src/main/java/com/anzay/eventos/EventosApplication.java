package com.anzay.eventos;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anzay.eventos.domain.Arbitro;
import com.anzay.eventos.domain.Classe;
import com.anzay.eventos.domain.Competicao;
import com.anzay.eventos.domain.Competidor;
import com.anzay.eventos.domain.Dancarino;
import com.anzay.eventos.domain.Endereco;
import com.anzay.eventos.domain.Estilo;
import com.anzay.eventos.domain.FaixaEtaria;
import com.anzay.eventos.domain.Formato;
import com.anzay.eventos.domain.Inscricao;
import com.anzay.eventos.domain.Modalidade;
import com.anzay.eventos.domain.Pessoa;
import com.anzay.eventos.domain.TipoParticipante;
import com.anzay.eventos.domain.enums.Sexo;
import com.anzay.eventos.domain.enums.TipoDocumento;
import com.anzay.eventos.domain.enums.TipoPessoa;
import com.anzay.eventos.repositories.ArbitroRepository;
import com.anzay.eventos.repositories.ClasseRepository;
import com.anzay.eventos.repositories.CompeticaoRepository;
import com.anzay.eventos.repositories.CompetidorRepository;
import com.anzay.eventos.repositories.DancarinoRepository;
import com.anzay.eventos.repositories.EnderecoRepository;
import com.anzay.eventos.repositories.EstiloRepository;
import com.anzay.eventos.repositories.FaixaEtariaRepository;
import com.anzay.eventos.repositories.FormatoRepository;
import com.anzay.eventos.repositories.InscricaoRepository;
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
	private CompeticaoRepository competicaoRepository;
	
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
	private InscricaoRepository inscricaoRepository;
	
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

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		// ----------------------------------------------------------------------------
		// USUÁRIOS
		// ----------------------------------------------------------------------------

		// PESSOA
		Pessoa pes1 = new Pessoa(null, "Michel", "12345678901", TipoDocumento.CPF, TipoPessoa.PESSOAFISICA, Sexo.MASCULINO,"5511911110001", "michelrosenblat@gmail.com");
		pessoaRepository.saveAll(Arrays.asList(pes1));
		
		
		// ----------------------------------------------------------------------------
		// ÁRBITROS 
		// ----------------------------------------------------------------------------

		// ÁRBITRO 
		Arbitro arb1 = new Arbitro(null, "Patric Tebaldi", "12345678901", TipoDocumento.CPF, TipoPessoa.PESSOAFISICA, Sexo.MASCULINO,"5511911110001", "michelrosenblat@gmail.com", "1234");
		Arbitro arb2 = new Arbitro(null, "Francesca Lazari", "EUA987ITA", TipoDocumento.PASSAPORTE, TipoPessoa.PESSOAFISICA, Sexo.FEMININO,"+1 368 654987", "michelrosenblat@gmail.com", "1234");
		arbitroRepository.saveAll(Arrays.asList(arb1, arb2));


		
		// ----------------------------------------------------------------------------
		// COMPETIDORES e DANÇARINIOS 
		// ----------------------------------------------------------------------------

		// COMPETIDORES
		Competidor comp1 = new Competidor(null, "Flavio Nunes", "12345678955", TipoDocumento.CPF, TipoPessoa.PESSOAFISICA, Sexo.MASCULINO,"5511911110001", "michelrosenblat@gmail.com");
		Competidor comp2 = new Competidor(null, "Miki Anzai", "12345678956", TipoDocumento.CPF, TipoPessoa.PESSOAFISICA, Sexo.FEMININO,"5511911110002", "michelrosenblat@gmail.com");
		Competidor comp3 = new Competidor(null, "Thiago Oliveira dos Santos", "12345678900", TipoDocumento.CPF, TipoPessoa.PESSOAFISICA, Sexo.FEMININO,"5511911110003", "michelrosenblat@gmail.com");
		Competidor comp4 = new Competidor(null, "Thais Correa Abuchacra", "12345678900", TipoDocumento.CPF, TipoPessoa.PESSOAFISICA, Sexo.FEMININO,"5511911110003", "michelrosenblat@gmail.com");
		Competidor comp5 = new Competidor(null, "Alexandre Las", "12345678955", TipoDocumento.CPF, TipoPessoa.PESSOAFISICA, Sexo.MASCULINO,"5511911110001", "michelrosenblat@gmail.com");
		Competidor comp6 = new Competidor(null, "Luciana Las", "12345678956", TipoDocumento.CPF, TipoPessoa.PESSOAFISICA, Sexo.FEMININO,"5511911110002", "michelrosenblat@gmail.com");

		// Enedereço dos Participantes
		Endereco endComp1 = new Endereco(null, "Rua dos Japoneses", "899", null, "Vila Nippon", "Sagamihara", "Kanagawa", "JAPÃO", "123456", comp1);
		Endereco endComp2 = new Endereco(null, "Rua dos Japonesas", "899", null, "Vila Nippon", "Sagamihara", "Kanagawa", "JAPÃO", "123456", comp2);
		Endereco endComp3 = new Endereco(null, "Rua das Artes", "s/n", null, "Jardim Visionário", "São Paulo", "São Paulo", "BRASIL", "02920001", comp3);
		Endereco endComp4 = new Endereco(null, "Avenida Yoga", "510", null, "Vila Abuchacra", "Belo Horizonte", "Minas Gerais", "BRASIL", "31000150", comp4);
		Endereco endComp5 = new Endereco(null, "Alameda Pelé", "14", null, "Parque Copa", "Santos", "SP", "BRASIL", "12000005", comp5);
		Endereco endComp6 = new Endereco(null, "Alameda Pelé", "14", null, "Parque Copa", "Santos", "SP", "BRASIL", "12000005", comp6);

		competidorRepository.saveAll(Arrays.asList(comp1, comp2, comp3, comp4, comp5, comp6));
		enderecoRepository.saveAll(Arrays.asList(endComp1, endComp2, endComp3, endComp4, endComp5, endComp6));

		// DANÇARINO 
		Dancarino dan1 = new Dancarino(null, "Tutu", "12345678902", TipoDocumento.CPF, TipoPessoa.PESSOAFISICA, Sexo.MASCULINO,"5511911110002", "michelrosenblat@gmail.com");

		// Enedereço do Dançarinio
		Endereco endDan1 = new Endereco(null, "Rua dos Dançarinos", "101", "Ap. 23", "Jardim Dançante", "Taubaté", "SP", "BRASIL", "19000001", dan1);

		dancarinoRepository.saveAll(Arrays.asList(dan1));
		enderecoRepository.saveAll(Arrays.asList(endDan1));
		
		
		
		// ----------------------------------------------------------------------------
		// MODALIDADE, ESTILO, CLASSE, FAIXA ETÁRIA 
		// ----------------------------------------------------------------------------


		// MODALIDADE
		
		Modalidade modStd = new Modalidade( null, "Standard");
		Modalidade modLat = new Modalidade( null, "Latin");
		Modalidade modSal = new Modalidade( null, "Dança de Salão");


		// ESTILOS
		
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
		Estilo estSal1 = new Estilo( null, "Bachata");	
		Estilo estSal2 = new Estilo( null, "Bolero");
		Estilo estSal3 = new Estilo( null, "Forró");
		Estilo estSal4 = new Estilo( null, "Gafieira");
		Estilo estSal5 = new Estilo( null, "Sertanejo");
		Estilo estSal6 = new Estilo( null, "Salsa");	
		Estilo estSal7 = new Estilo( null, "Samba-Rock");
		Estilo estSal8 = new Estilo( null, "Tango");
		Estilo estSal9 = new Estilo( null, "Zouk");	


		// ESTILOS E MODALIDADES
		
		// Insere Estilos nas Modalidades
		modStd.getEstilos().addAll(Arrays.asList(estSt1, estSt2, estSt3, estSt4, estSt5));
		modLat.getEstilos().addAll(Arrays.asList(estLt1, estLt2, estLt3, estLt4, estLt5));
		modSal.getEstilos().addAll(Arrays.asList(estSal1, estSal2, estSal3, estSal4, estSal5, estSal6, estSal7, estSal8, estSal9));

		
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
		estSal1.getModalidades().addAll(Arrays.asList( modSal ));
		estSal2.getModalidades().addAll(Arrays.asList( modSal ));
		estSal3.getModalidades().addAll(Arrays.asList( modSal ));
		estSal4.getModalidades().addAll(Arrays.asList( modSal ));
		estSal5.getModalidades().addAll(Arrays.asList( modSal ));
		estSal6.getModalidades().addAll(Arrays.asList( modSal ));
		estSal7.getModalidades().addAll(Arrays.asList( modSal ));
		estSal8.getModalidades().addAll(Arrays.asList( modSal ));
		estSal9.getModalidades().addAll(Arrays.asList( modSal ));

		
		// ÁRBITRO E MODALIDADE
		
		// Insere Árbitro nas Modalidades
		modStd.getArbitros().addAll(Arrays.asList(arb1, arb2));
		modLat.getArbitros().addAll(Arrays.asList(arb1, arb2));
		modSal.getArbitros().addAll(Arrays.asList(arb1));
		
		// Insere as Modalidades nos Árbitros
		arb1.getModalidades().addAll(Arrays.asList( modStd, modLat, modSal ));
		arb2.getModalidades().addAll(Arrays.asList( modStd, modLat));

		modalidadeRepository.saveAll(Arrays.asList(modStd, modLat, modSal));
				
		arbitroRepository.saveAll(Arrays.asList(arb1, arb2));
		
		estiloRepository.saveAll(Arrays.asList(estSt1, estSt2, estSt3, estSt4, estSt5, estLt1, estLt2, estLt3, estLt4, estLt5, estSal1, estSal2, estSal3, estSal4, estSal5, estSal6, estSal7, estSal8, estSal9));

		

		// TIPO PARTICIPANTE
		
		TipoParticipante tpCasal = new TipoParticipante(null, "Casal", 2, 2);
		TipoParticipante tpSolo = new TipoParticipante(null, "Solo", 2, 2);
		TipoParticipante tpGrpPeq = new TipoParticipante(null, "Grupo Coreográfico Pequeno", 3, 7);
		TipoParticipante tpGrpGrd = new TipoParticipante(null, "Grupo Coreográfico Grande", 8, 20);
		TipoParticipante tpTime = new TipoParticipante(null, "Time", 5, 5);
		TipoParticipante tpSameSex = new TipoParticipante(null, "Same Sex", 2, 2);
		TipoParticipante tpProAm = new TipoParticipante(null, "Pro/Am", 2, 2);
		
		tipoParticipanteRepository.saveAll(Arrays.asList(tpCasal, tpSolo, tpGrpPeq, tpGrpGrd, tpTime, tpSameSex, tpProAm));	
		

		// CLASSES
		
		Classe clsA = new Classe(null, "A");
		Classe clsB = new Classe(null, "B");
		Classe clsC = new Classe(null, "C");
		Classe clsD = new Classe(null, "D");
		Classe clsE = new Classe(null, "E");
		Classe clsF = new Classe(null, "F");
		Classe clsNC = new Classe(null, "Newcomer");

		Classe clsInici = new Classe(null, "Iniciante");
		Classe clsInter = new Classe(null, "Intermediário");
		Classe clsAvanc = new Classe(null, "Avançado");

		Classe clsBron = new Classe(null, "Bronze");
		Classe clsSilv = new Classe(null, "Silver");
		Classe clsGold = new Classe(null, "Gold");

		classeRepository.saveAll(Arrays.asList(clsA, clsB, clsC, clsD, clsE, clsF, clsNC, clsInici, clsInter, clsAvanc, clsBron, clsSilv, clsGold ));		

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
		


		
		// ----------------------------------------------------------------------------
		// FORMATO
		// ----------------------------------------------------------------------------

		// FORMATOS

		Formato fmt1 = new Formato(null, "Casal Standard Classe F/E Adulto", modStd, tpCasal);
		Formato fmt2 = new Formato(null, "Casal Latin Classe F/E Adulto", modLat, tpCasal);
		Formato fmt3 = new Formato(null, "Solo Latin Classe D Youth", modLat, tpSolo);

		tpCasal.getFormatos().addAll(Arrays.asList(fmt1, fmt2));
		tpSolo.getFormatos().addAll(Arrays.asList(fmt3));

		// CLASSES DO FORMATO
		fmt1.getClasses().addAll(Arrays.asList(clsF, clsE));
		fmt2.getClasses().addAll(Arrays.asList(clsF, clsE));
		fmt3.getClasses().addAll(Arrays.asList(clsD));

		clsF.getFormatos().addAll(Arrays.asList(fmt1, fmt2));
		clsE.getFormatos().addAll(Arrays.asList(fmt1, fmt2));
		clsD.getFormatos().addAll(Arrays.asList(fmt3));

		
		// FAIXA ETÁRIA
		fmt1.getFaixaEtarias().addAll(Arrays.asList(fe7));
		fmt2.getFaixaEtarias().addAll(Arrays.asList(fe7));
		fmt3.getFaixaEtarias().addAll(Arrays.asList(fe6));

		fe7.getFormatos().addAll(Arrays.asList(fmt1, fmt2));
		fe6.getFormatos().addAll(Arrays.asList(fmt3));
		
		faixaEtariaRepository.saveAll(Arrays.asList(fe1, fe2, fe3, fe4, fe5, fe6, fe7, fe8, fe9, fe10, fe11, fe12, fe13, fe14, fe15, fe16));
		
		
		// ESTILOS
		fmt1.getEstilos().addAll(Arrays.asList(estSt1, estSt2, estSt3));
		fmt2.getEstilos().addAll(Arrays.asList(estLt1, estLt2, estLt3));
		fmt3.getEstilos().addAll(Arrays.asList(estLt1, estLt2, estLt3, estLt4, estLt5));
		estSt1.getFormatos().addAll(Arrays.asList(fmt1));
		estSt2.getFormatos().addAll(Arrays.asList(fmt1));
		estSt3.getFormatos().addAll(Arrays.asList(fmt1));
		estLt1.getFormatos().addAll(Arrays.asList(fmt2, fmt3));
		estLt2.getFormatos().addAll(Arrays.asList(fmt2, fmt3));
		estLt3.getFormatos().addAll(Arrays.asList(fmt2, fmt3));
		estLt4.getFormatos().addAll(Arrays.asList(fmt3));
		estLt5.getFormatos().addAll(Arrays.asList(fmt3));


		formatoRepository.saveAll(Arrays.asList(fmt1, fmt2, fmt3));

		

		// ----------------------------------------------------------------------------
		// COMPETICAO
		// ----------------------------------------------------------------------------

		// ------------------------------------------------------------------------------------------
		// COMPETICAO 

		Competicao compStdAdulto = new Competicao(null, "FIDES2019 - Standard Classe E/F Adulto ", fmt1);
		Competicao compLatAdulto = new Competicao(null, "FIDES2019 - Latin Classe E/F Adulto ", fmt2);
		Competicao compSoloLatYouth = new Competicao(null, "FIDES2019 - Solo Latin D Youth", fmt3);


		fmt1.getCompeticoes().addAll(Arrays.asList(compStdAdulto));
		fmt2.getCompeticoes().addAll(Arrays.asList(compLatAdulto));
		fmt3.getCompeticoes().addAll(Arrays.asList(compSoloLatYouth));

		competicaoRepository.saveAll(Arrays.asList(compStdAdulto, compLatAdulto, compSoloLatYouth));
		

		// ------------------------------------------------------------------------------------------
		// INSCRIÇÃO 

		Inscricao insc1 = new Inscricao(null, compStdAdulto, sdf.parse("11/09/2019 12:01"));
		Inscricao insc2 = new Inscricao(null, compStdAdulto, sdf.parse("18/09/2019 15:25"));
		Inscricao insc3 = new Inscricao(null, compStdAdulto, sdf.parse("05/10/2019 09:37"));
		Inscricao insc4 = new Inscricao(null, compSoloLatYouth, sdf.parse("05/10/2019 09:51"));

		insc1.getCompetidores().addAll(Arrays.asList(comp1, comp2));
		insc2.getCompetidores().addAll(Arrays.asList(comp3, comp4));
		insc3.getCompetidores().addAll(Arrays.asList(comp5, comp6));
		insc4.getCompetidores().addAll(Arrays.asList(comp6));
		
		inscricaoRepository.saveAll(Arrays.asList(insc1, insc2, insc3, insc4));
		
	}

}
