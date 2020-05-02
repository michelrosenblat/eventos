package com.anzay.eventos.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.anzay.eventos.domain.enums.Sexo;
import com.anzay.eventos.domain.enums.TipoDocumento;
import com.anzay.eventos.domain.enums.TipoPessoa;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String documento;
	private Integer tipoDocumento;
	private Integer tipoPessoa;
	private Integer sexo;
	private String telefonePrincipal;
	private String emailPrincipal;

	//@JsonManagedReference
	@OneToMany(mappedBy="pessoa")
	private Set<Endereco> enderecos = new HashSet<>();
	
	//private Set<String> telefones = new HashSet();
	
	public Pessoa() {
	}

	public Pessoa(Integer id, String nome, String documento, TipoDocumento tipoDocumento, TipoPessoa tipoPessoa, Sexo sexo,
			String telefonePrincipal, String emailPrincipal) {
		super();
		this.id = id;
		this.nome = nome;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento.getCod();
		this.tipoPessoa = tipoPessoa.getCod();
		this.sexo = sexo.getCod();
		this.telefonePrincipal = telefonePrincipal;
		this.emailPrincipal = emailPrincipal;
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Integer getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Integer getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(Integer tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public Integer getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	public String getTelefonePrincipal() {
		return telefonePrincipal;
	}

	public void setTelefonePrincipal(String telefonePrincipal) {
		this.telefonePrincipal = telefonePrincipal;
	}

	public String getEmailPrincipal() {
		return emailPrincipal;
	}

	public void setEmailPrincipal(String emailPrincipal) {
		this.emailPrincipal = emailPrincipal;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}


	
}
