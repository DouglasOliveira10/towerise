package br.com.towerise.core.port.out;

import java.util.List;

import br.com.towerise.core.dto.AlexaWebhookDTO;
import jakarta.validation.Valid;

public interface AlexaDao {

	AlexaWebhookDTO cadastrarWebhookNoticacao(@Valid AlexaWebhookDTO alexaWebhookDTO);

	List<AlexaWebhookDTO> buscarAlexaWebhooks();

	AlexaWebhookDTO buscarAlexaWebhooksByMoradorId(Long id);

}
