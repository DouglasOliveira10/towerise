package br.com.towerise.core.port.in;

import java.util.List;

import br.com.towerise.core.dto.AlexaWebhookDTO;
import jakarta.validation.Valid;

public interface AlexaService {

	AlexaWebhookDTO cadastrarAlexaWebhook(@Valid AlexaWebhookDTO alexaWebhookDTO);

	List<AlexaWebhookDTO> buscarAlexaWebhooks();

}
