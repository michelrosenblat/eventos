package com.anzay.eventos.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Estilo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;


	/*
	@JsonIgnore
	@ManyToMany(mappedBy="estilos")								// lista na outra classe
	private Set<Modalidade> modalidades = new HashSet<>();		// lista que a outra classe usará
*/
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "ESTILOS_DA_MODALIDADE",
		joinColumns = @JoinColumn(name = "estilo_id"),
		inverseJoinColumns = @JoinColumn(name = "modalidade_id")
	)
	private Set<Modalidade> modalidades = new HashSet<>();

	
	// *** CONFERIDO ***
	@JsonIgnore
	@ManyToMany(mappedBy="estilos")
	private Set<Formato> formatos = new HashSet<>();
	
	
	public Estilo() {
	
	}

	public Estilo(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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

	public Set<Modalidade> getModalidades() {
		return modalidades;
	}

	public void setModalidades(Set<Modalidade> modalidades) {
		this.modalidades = modalidades;
	}
	
	

	public Set<Formato> getFormatos() {
		return formatos;
	}

	public void setFormatos(Set<Formato> formatos) {
		this.formatos = formatos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estilo other = (Estilo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}