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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity 
public class Formato implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	// *** CONFERIDO ***
	//
	@ManyToOne
	@JoinColumn(name="modalidade_id")
	private Modalidade modalidade;
	
	@ManyToOne
	@JoinColumn(name="tipoParticipante_id")
	private TipoParticipante tipoParticipante; 


	@ManyToMany
	@JoinTable(name = "CLASSES_DO_FORMATO",
		joinColumns = @JoinColumn(name = "formato_id"),
		inverseJoinColumns = @JoinColumn(name = "classe_id")
	)
	private List<Classe> classes = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "FAIXAETARIAS_DO_FORMATO",
		joinColumns = @JoinColumn(name = "formato_id"),
		inverseJoinColumns = @JoinColumn(name = "faixaetaria_id")
	)
	private List<FaixaEtaria> faixaEtarias = new ArrayList<>();

	// *** CONFERIDO ***
	@ManyToMany
	@JoinTable(name = "ESTILOS_DO_FORMATO",
		joinColumns = @JoinColumn(name = "formato_id"),
		inverseJoinColumns = @JoinColumn(name = "estilo_id")
	)
	private List<Estilo> estilos = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy="formato")
	private Set<Competicao> competicoes = new HashSet<>();
	
	
	public Formato() {
	}
			


	public Formato(Integer id, String nome, Modalidade modalidade, TipoParticipante tipoParticipante) {
		super();
		this.id = id;
		this.nome = nome;
		this.modalidade = modalidade;
		this.tipoParticipante = tipoParticipante;
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

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public TipoParticipante getTipoParticipante() {
		return tipoParticipante;
	}

	public void setTipoParticipante(TipoParticipante tipoParticipante) {
		this.tipoParticipante = tipoParticipante;
	}


	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}

	public List<Estilo> getEstilos() {
		return estilos;
	}

	public void setEstilos(List<Estilo> estilos) {
		this.estilos = estilos;
	}

	public List<FaixaEtaria> getFaixaEtarias() {
		return faixaEtarias;
	}

	public void setFaixaEtarias(List<FaixaEtaria> faixaEtarias) {
		this.faixaEtarias = faixaEtarias;
	}

	
	public Set<Competicao> getCompeticoes() {
		return competicoes;
	}

	public void setCompeticoes(Set<Competicao> competicoes) {
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
		Formato other = (Formato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	} 



}
