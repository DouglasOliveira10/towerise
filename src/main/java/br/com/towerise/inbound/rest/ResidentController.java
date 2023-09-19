package br.com.towerise.inbound.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.towerise.core.dto.AlexaWebhookDTO;
import br.com.towerise.core.exception.AlexaException;
import br.com.towerise.core.port.in.AlexaService;
import br.com.towerise.inbound.rest.responses.ResponseAPI;
import br.com.towerise.inbound.rest.responses.ResponseItems;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("morador")
public class ResidentController {
	
	@Autowired
	private AlexaService alexaService; 

	
	@PostMapping("/alexa/webhook")
	@ResponseStatus(HttpStatus.OK)
	public ResponseAPI cadastrarAlexaWebhook(@Valid @RequestBody AlexaWebhookDTO alexaWebhookDTO) throws AlexaException {
		log.info("Cadastrando novo webhhok para alexa: {}", alexaWebhookDTO);
		var dtoSalvo = alexaService.cadastrarAlexaWebhook(alexaWebhookDTO);

		return ResponseAPI.builder()
				.httpStatusCode(HttpStatus.OK.value())
				.data(dtoSalvo)
				.build();
	}
	
	@GetMapping("/alexa/webhook")
	public ResponseAPI buscarAlexaWebhooks() throws AlexaException {
		log.info("Buscando alexa webhooks cadastrados}");
		var listaDto = alexaService.buscarAlexaWebhooks();
		
		var items = ResponseItems.builder()
				.items(listaDto)
				.build();
		
		return ResponseAPI.builder()
				.httpStatusCode(HttpStatus.OK.value())
				.data(items)
				.build();
	}

}
