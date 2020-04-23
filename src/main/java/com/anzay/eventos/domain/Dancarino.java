package com.anzay.eventos.domain;

import javax.persistence.Entity;

import com.anzay.eventos.domain.enums.TipoDocumento;
import com.anzay.eventos.domain.enums.TipoPessoa;

@Entity
public class Dancarino extends Pessoa {

	private static final long serialVersionUID = 1L;

	public Dancarino() {
		
	}

	public Dancarino(Integer id, String nome, String documento, TipoDocumento tipoDocumento, TipoPessoa tipoPessoa,
			String telefonePrincipal, String emailPrincipal) {

		super(id, nome, documento, tipoDocumento, tipoPessoa, telefonePrincipal, emailPrincipal);


	}
	
	
	
}
