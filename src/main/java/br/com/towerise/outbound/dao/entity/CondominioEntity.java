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
@Table(name = "condominio")
public class CondominioEntity {

	@Id
	@SequenceGenerator(name="condominio_seq", allocationSize=10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "condominio_seq")
	private Long id;
	private String nome;
	private String endereco;	
	private String bairro;	
	private String cidade;	
	private String estado;	
	private String cep;	
	private String telefone;	
	private String email;	
}