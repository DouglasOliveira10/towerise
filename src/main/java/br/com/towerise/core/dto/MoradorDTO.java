package br.com.towerise.core.dto;

import lombok.Data;

@Data
public class MoradorDTO {
	
	private String nome;
	private String dataNascimento;
	private String rg;	
	private String cpf;	
	private String bloco;	
	private String unidade;	
	private String telefone;	
	private String email;	
	private Long idCondominio;
	
	// outros params...
}
