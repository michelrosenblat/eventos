package com.anzay.eventos.domain;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.anzay.eventos.domain.enums.Sexo;
import com.anzay.eventos.domain.enums.TipoDocumento;
import com.anzay.eventos.domain.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Competidor extends Dancarino{

	private static final long serialVersionUID = 1L;

	// join com MODALIDADE
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "COMPETIDORES_DA_MODALIDADE",
			joinColumns = @JoinColumn(name = "competidor_id"),
			inverseJoinColumns = @JoinColumn(name = "modalidade_id")
	)
	private Set<Modalidade> modalidades = new HashSet<>();

	// join com MODALIDADE
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "COMPETIDORES_DA_INSCRICAO",
			joinColumns = @JoinColumn(name = "competidor_id"),
			inverseJoinColumns = @JoinColumn(name = "inscricaoCompetidor_id")
	)
	private Set<InscricaoCompeticao> inscricoesCompetidor = new HashSet<>();

		
	
	public Competidor() {
		
	}

	public Competidor(Integer id, String nome, String documento, TipoDocumento tipoDocumento, TipoPessoa tipoPessoa, Sexo sexo,
			String telefonePrincipal, String emailPrincipal) {
		
		super(id, nome, documento, tipoDocumento, tipoPessoa, sexo, telefonePrincipal, emailPrincipal);
		
	}

	public Set<Modalidade> getModalidades() {
		return modalidades;
	}

	public void setModalidades(Set<Modalidade> modalidades) {
		this.modalidades = modalidades;
	}

	public Set<InscricaoCompeticao> getInscricoes() {
		return inscricoesCompetidor;
	}

	public void setInscricoes(Set<InscricaoCompeticao> inscricoes) {
		this.inscricoesCompetidor = inscricoes;
	}



	
}
