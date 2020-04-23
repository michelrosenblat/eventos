package com.anzay.eventos.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.anzay.eventos.domain.enums.TipoDocumento;
import com.anzay.eventos.domain.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Arbitro extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String pin;

	

	// join com MODALIDADE
	@JsonBackReference
	@ManyToMany
	@JoinTable(
			name = "ARBITROS_DA_MODALIDE",
			joinColumns = @JoinColumn(name = "arbitro_id"),
			inverseJoinColumns = @JoinColumn(name = "modalidade_id")
	)
	private List<Modalidade> modalidades = new ArrayList<>();


	public Arbitro() {
		
	}

	public Arbitro(Integer id, String nome, String documento, TipoDocumento tipoDocumento, TipoPessoa tipoPessoa,
			String telefonePrincipal, String emailPrincipal, String pin) {

		super(id, nome, documento, tipoDocumento, tipoPessoa, telefonePrincipal, emailPrincipal);
		
		this.pin = pin;

	}
	
	public List<Modalidade> getModalidades() {
		return modalidades;
	}

	public void setModalidades(List<Modalidade> modalidades) {
		this.modalidades = modalidades;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	
}
