package com.anzay.eventos.domain.enums;

public enum TipoDocumento {

	CPF(1 , "CPF"),
	PASSAPORTE(2, "Passaporte"),
	RG(3 , "RG"),
	RGE(4, "RGE"),
	CNPJ(5 , "CNPJ");
	
	private int cod;
	private String descricao;
	
	private TipoDocumento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public static TipoDocumento toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoDocumento x : TipoDocumento.values()) {
				if (cod.equals(x.getCod())) {
					return x;
				}
		}
		
		throw new IllegalArgumentException("Id inválido do enum TipoDocumento: " + cod);

	}

}