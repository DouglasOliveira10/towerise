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
@Table(name = "morador")
public class MoradorEntity {
	
	@Id
	@SequenceGenerator(name="morador_seq", allocationSize=10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "morador_seq")
	private Long id;
	private String nome;
	private String dataNascimento;
	private String rg;	
	private String cpf;	
	private String bloco;	
	private String unidade;	
	private String telefone;	
	private String email;	
	private Long idCondominio;
}
