package com.anzay.eventos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InscricaoCompeticao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date dataInscricao;
	
	private Competidor competidorLeader;
	
	// join com COMPETIDORES
	@ManyToMany(mappedBy = "inscricoesCompetidor")
	private Set<Competidor> competidores = new HashSet<>();
			
	
	// join com COMPETIÇÕES
	@JsonIgnore
	@ManyToMany(mappedBy = "inscricoesCompeticao")
	private List<Competicao> competicoes = new ArrayList<>();
			
	
	public InscricaoCompeticao() {
		
	}

	public InscricaoCompeticao(Integer id, Date dataInscricao, Competidor competidorLeader) {
		super();
		this.id = id;
		this.dataInscricao = dataInscricao;
		this.competidorLeader = competidorLeader;
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(Date dataInscricao) {
		this.dataInscricao = dataInscricao;
	}

	public Competidor getCompetidorLeader() {
		return competidorLeader;
	}

	public void setCompetidorLeader(Competidor competidorLeader) {
		this.competidorLeader = competidorLeader;
	}

	public Set<Competidor> getCompetidores() {
		return competidores;
	}

	public void setCompetidores(Set<Competidor> competidores) {
		this.competidores = competidores;
	}

	public List<Competicao> getInscricoesCompeticao() {
		return competicoes;
	}

	public void setInscricoesCompeticao(List<Competicao> competicoes) {
		this.competicoes = competicoes;
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
		InscricaoCompeticao other = (InscricaoCompeticao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}