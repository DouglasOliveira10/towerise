package br.com.towerise.core.dto;

import lombok.Data;

@Data
public class AlexaWebhookDTO {
	
	private Long id;
	private String webhookVisitante;
	private String webhookCorrespondencia;
	private Long idMorador;
}
