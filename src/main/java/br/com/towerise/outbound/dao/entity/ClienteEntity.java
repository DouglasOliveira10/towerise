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
@Table(name = "cliente")
public class ClienteEntity {

	@Id
	@SequenceGenerator(name="cliente_seq", initialValue=10, allocationSize=10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
	private Long id;
	private String nome;
	private Integer idade;	
}