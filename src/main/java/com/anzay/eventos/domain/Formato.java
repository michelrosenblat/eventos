package com.anzay.eventos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity 
public class Formato implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	// MODALIDADE
	@ManyToOne
	@JoinColumn(name="modalidade_id")
	private Modalidade modalidade;
	

	// TIPO PARTICIPANTE
	@ManyToOne
	@JoinColumn(name="tipoParticipante_id")
	private TipoParticipante tipoParticipante = new TipoParticipante(); 

	// join com CLASSES
	//@JsonManagedReference
	@ManyToMany(mappedBy = "formatos")
	private List<Classe> classes = new ArrayList<>();

	// join com FAIXA ETÁRIA
	//@JsonManagedReference
	@ManyToMany(mappedBy = "formatos")
	private List<FaixaEtaria> faixaEtarias = new ArrayList<>();

	// join com ESTILOS
	//@JsonManagedReference
	@ManyToMany(mappedBy = "formatos")
	private List<Estilo> estilos = new ArrayList<>();

	
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
