package com.anzay.eventos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TipoParticipante implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer minCompedidores;
	private Integer maxCompedidores;
	
	public Integer getMinCompedidores() {
		return minCompedidores;
	}


	public void setMinCompedidores(Integer minCompedidores) {
		this.minCompedidores = minCompedidores;
	}


	public Integer getMaxCompedidores() {
		return maxCompedidores;
	}


	public void setMaxCompedidores(Integer maxCompedidores) {
		this.maxCompedidores = maxCompedidores;
	}

	@JsonIgnore
	@OneToMany(mappedBy="tipoParticipante")
	private List<Formato> formatos = new ArrayList<>();
	


	public TipoParticipante() {
		
	}

	
	public TipoParticipante(Integer id, String nome, Integer minCompedidores, Integer maxCompedidores) {
		super();
		this.id = id;
		this.nome = nome;
		this.minCompedidores = minCompedidores;
		this.maxCompedidores = maxCompedidores;
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

	public Integer getMinParticipantes() {
		return minCompedidores;
	}

	public void setMinParticipantes(Integer minCompedidores) {
		this.minCompedidores = minCompedidores;
	}

	public Integer getMaxParticipantes() {
		return maxCompedidores;
	}

	public void setMaxParticipantes(Integer maxCompedidores) {
		this.maxCompedidores = maxCompedidores;
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
		TipoParticipante other = (TipoParticipante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
}
