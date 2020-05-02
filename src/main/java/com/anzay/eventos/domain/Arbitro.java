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
public class Arbitro extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String pin;


  	@JsonIgnore
	@ManyToMany(mappedBy="arbitros")
	private Set<Modalidade> modalidades = new HashSet<>();

	public Arbitro() {
		
	}

	public Arbitro(Integer id, String nome, String documento, TipoDocumento tipoDocumento, TipoPessoa tipoPessoa, Sexo sexo,
			String telefonePrincipal, String emailPrincipal, String pin) {

		super(id, nome, documento, tipoDocumento, tipoPessoa, sexo,  telefonePrincipal, emailPrincipal);
		
		this.pin = pin;

	}
	

	
	public Set<Modalidade> getModalidades() {
		return modalidades;
	}

	public void setModalidades(Set<Modalidade> modalidades) {
		this.modalidades = modalidades;
	}


	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	
}
