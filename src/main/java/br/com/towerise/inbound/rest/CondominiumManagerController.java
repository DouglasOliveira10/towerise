package br.com.towerise.inbound.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.towerise.core.dto.MoradorDTO;
import br.com.towerise.core.exception.NotificationException;
import br.com.towerise.core.exception.ParamException;
import br.com.towerise.core.port.in.NotificationService;
import br.com.towerise.core.port.in.ParamService;
import br.com.towerise.inbound.rest.responses.ResponseAPI;
import br.com.towerise.inbound.rest.responses.ResponseItems;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/condominio")
public class CondominiumManagerController {
	
	@Autowired
	private ParamService paramService;
	
	@Autowired
	private NotificationService notificationService;
	
	@PostMapping("/morador")
	@ResponseStatus(HttpStatus.OK)
	public ResponseAPI cadastrarMorador(@Valid @RequestBody MoradorDTO moradorDTO) throws ParamException {
		log.info("Cadastrando novo morador: {}", moradorDTO);
		var dtoSalvo = paramService.cadastrarMorador(moradorDTO);

		return ResponseAPI.builder()
				.httpStatusCode(HttpStatus.OK.value())
				.data(dtoSalvo)
				.build();
	}
	
	@GetMapping("/morador")
	public ResponseAPI buscarMoradores() throws ParamException {
		log.info("Buscando moradores cadastrados.");
		var listaDto = paramService.buscarMoradores();
		
		var items = ResponseItems.builder()
				.items(listaDto)
				.build();
		
		return ResponseAPI.builder()
				.httpStatusCode(HttpStatus.OK.value())
				.data(items)
				.build();
	}
	
	@GetMapping("/morador/{idMorador}/notificacao-visitante")
	public ResponseAPI notificarVisitante(@PathVariable(value = "idMorador") Long id) throws NotificationException {
		log.info("Notificação de visita para o morador: {}", id);
		notificationService.notificarVisitante(id);		

		return ResponseAPI.builder()
				.httpStatusCode(HttpStatus.OK.value()).build();
	}

}
