package com.anzay.eventos.domain;


import java.util.ArrayList;
import java.util.List;

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
	//@JsonBackReference
	@ManyToMany
	@JoinTable(
			name = "COMPETIDORES_DA_MODALIDE",
			joinColumns = @JoinColumn(name = "competidor_id"),
			inverseJoinColumns = @JoinColumn(name = "modalidade_id")
	)
	private List<Modalidade> modalidades = new ArrayList<>();

	
	public Competidor() {
		
	}

	public Competidor(Integer id, String nome, String documento, TipoDocumento tipoDocumento, TipoPessoa tipoPessoa, Sexo sexo,
			String telefonePrincipal, String emailPrincipal) {
		
		super(id, nome, documento, tipoDocumento, tipoPessoa, sexo, telefonePrincipal, emailPrincipal);
		
	}


	public List<Modalidade> getModalidades() {
		return modalidades;
	}

	public void setModalidades(List<Modalidade> modalidades) {
		this.modalidades = modalidades;
	}

}
