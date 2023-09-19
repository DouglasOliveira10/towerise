package br.com.towerise.core.dto;

import lombok.Data;

@Data
public class SindicoDTO {
	
	private String nome;
	private String dataNascimento;
	private String rg;	
	private String cpf;	
	private String cnpj;	
	private String inicioMandato;	
	private String fimMandato;	
	private String endereco;	
	private String bairro;	
	private String cidade;	
	private String estado;	
	private String telefone;	
	private String email;	
	private String cep;	
	private Long idCondominio;	
	
	// outros params...
}
