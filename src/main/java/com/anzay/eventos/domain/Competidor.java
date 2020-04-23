package com.anzay.eventos.domain;


import com.anzay.eventos.domain.enums.TipoDocumento;
import com.anzay.eventos.domain.enums.TipoPessoa;

public class Competidor extends Dancarino{

	private static final long serialVersionUID = 1L;

	public Competidor() {
		
	}

	public Competidor(Integer id, String nome, String documento, TipoDocumento tipoDocumento, TipoPessoa tipoPessoa,
			String telefonePrincipal, String emailPrincipal) {
		
		super(id, nome, documento, tipoDocumento, tipoPessoa, telefonePrincipal, emailPrincipal);
		
	}

}
