package com.anzay.eventos.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Inscricao  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="competicao_id")
	private Competicao competicao;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataInscricao;

	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="leader_id")
	private Competidor leader;
	

	@ManyToMany
	@JoinTable(name = "COMPETIDORES_DA_INSCRICAO",
		joinColumns = @JoinColumn(name = "inscricao_id"),
		inverseJoinColumns = @JoinColumn(name = "competidor_id")
	)
	private Set<Competidor> competidores = new HashSet<>();	
	
	
	public Inscricao() {
		
	}

	public Inscricao(Integer id, Competicao competicao, Date dataInscricao, Competidor leader) {
		super();
		this.id = id;
		this.competicao = competicao;
		this.dataInscricao = dataInscricao;
		this.leader = leader;
	}



	public Set<Competidor> getCompetidores() {
		return competidores;
	}

	public void setCompetidores(Set<Competidor> competidores) {
		this.competidores = competidores;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Competicao getCompeticao() {
		return competicao;
	}

	public void setCompeticao(Competicao competicao) {
		this.competicao = competicao;
	}

	public Date getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(Date dataInscricao) {
		this.dataInscricao = dataInscricao;
	}

	
	
	public Competidor getLeader() {
		return leader;
	}

	public void setLeader(Competidor leader) {
		this.leader = leader;
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
		Inscricao other = (Inscricao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
