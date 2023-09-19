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
@Table(name = "alexa_webhook")
public class AlexaWebhookEntity {
	
	@Id
	@SequenceGenerator(name="alexa_webhook_seq", allocationSize=10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alexa_webhook_seq")
	private Long id;
	private String webhookVisitante;
	private String webhookCorrespondencia;
	private Long idMorador;

}
