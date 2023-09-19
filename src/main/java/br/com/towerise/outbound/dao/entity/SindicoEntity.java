package br.com.towerise.outbound.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sindico")
public class SindicoEntity {
	
	@Id
	@SequenceGenerator(name="sindico_seq", allocationSize=10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sindico_seq")
	private Long id;
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
}
