package com.anzay.eventos.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FaixaEtaria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer idadeMin;
	private Integer idadeMax;

	public FaixaEtaria() {
		
	}

	

	public FaixaEtaria(Integer id, String nome, Integer idadeMin, Integer idadeMax) {
		super();
		this.id = id;
		this.nome = nome;
		this.idadeMin = idadeMin;
		this.idadeMax = idadeMax;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Integer getIdadeMin() {
		return idadeMin;
	}



	public void setIdadeMin(Integer idadeMin) {
		this.idadeMin = idadeMin;
	}



	public Integer getIdadeMax() {
		return idadeMax;
	}



	public void setIdadeMax(Integer idadeMax) {
		this.idadeMax = idadeMax;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FaixaEtaria other = (FaixaEtaria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
