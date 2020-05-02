package com.anzay.eventos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Modalidade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;


/*
  	@JsonIgnore
	@ManyToMany(mappedBy="modalidades")
	private Set<Arbitro> arbitros = new HashSet<>();
*/
	@ManyToMany
	@JoinTable(name = "MODALIDADES_DO_ARBITRO",
		joinColumns = @JoinColumn(name = "modalidade_id"),
		inverseJoinColumns = @JoinColumn(name = "arbitro_id")
	)
	private Set<Arbitro> arbitros = new HashSet<>();


	// *** CONFERIDO ***
	@JsonIgnore
	@OneToMany(mappedBy="modalidade")
	private List<Formato> formatos = new ArrayList<>();

	//@JsonIgnore
	@ManyToMany(mappedBy="modalidades")								// lista na outra classe
	private Set<Estilo> estilos = new HashSet<>();		// lista que a outra classe usará
	
	public Modalidade() {
	}

	public Modalidade(Integer id, String nome) {
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

	public Set<Estilo> getEstilos() {
		return estilos;
	}

	public void setEstilos(Set<Estilo> estilos) {
		this.estilos = estilos;
	}



	public Set<Arbitro> getArbitros() {
		return arbitros;
	}

	public void setArbitros(Set<Arbitro> arbitros) {
		this.arbitros = arbitros;
	}

	
	public List<Formato> getFormatos() {
		return formatos;
	}

	public void setFormatos(List<Formato> formatos) {
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
		Modalidade other = (Modalidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
