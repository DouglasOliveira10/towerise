package br.com.towerise.core.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CondominioDTO {
	
	private Long id;
	
	@NotBlank
	private String nome;
	private String endereco;	
	private String bairro;	
	private String cidade;	
	private String estado;	
	private String cep;	
	private String telefone;	
	private String email;	
	
	// outros params...
}
