package br.com.towerise.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.towerise.core.dto.AlexaWebhookDTO;
import br.com.towerise.core.exception.NotificationException;
import br.com.towerise.core.port.in.NotificationService;
import br.com.towerise.core.port.out.AlexaDao;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	private AlexaDao alexaDao;

	@Override
	public void notificarVisitante(Long id) throws NotificationException {
		AlexaWebhookDTO dto = alexaDao.buscarAlexaWebhooksByMoradorId(id);
		
		if(dto == null || dto.getWebhookVisitante() == null) return;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(dto.getWebhookVisitante(), String.class);
		
		if(HttpStatus.OK == response.getStatusCode())
			log.info("Alexa do morador {} notificada com sucesso!", id);
		else
			log.warn("Falha ao notifica alexa do morador: {}", id);
	}

}
