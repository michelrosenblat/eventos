package com.anzay.eventos.domain;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.anzay.eventos.domain.enums.Sexo;
import com.anzay.eventos.domain.enums.TipoDocumento;
import com.anzay.eventos.domain.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Competidor extends Dancarino{

	private static final long serialVersionUID = 1L;

  	@JsonIgnore
	@ManyToMany(mappedBy="competidores")
	private Set<Inscricao> inscricoes = new HashSet<>();
  	
		
	public Competidor() {
		
	}

	public Competidor(Integer id, String nome, String documento, TipoDocumento tipoDocumento, TipoPessoa tipoPessoa, Sexo sexo,
			String telefonePrincipal, String emailPrincipal) {
		
		super(id, nome, documento, tipoDocumento, tipoPessoa, sexo, telefonePrincipal, emailPrincipal);
		
	}

	public Set<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(Set<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}

}
