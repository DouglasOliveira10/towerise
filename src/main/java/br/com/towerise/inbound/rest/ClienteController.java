package br.com.towerise.inbound.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.towerise.core.dto.ClienteDTO;
import br.com.towerise.core.exception.ClienteException;
import br.com.towerise.core.port.in.ClienteService;
import br.com.towerise.inbound.rest.responses.ResponseAPI;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseAPI findById(@PathVariable(value = "id") Long id) throws ClienteException {
		log.info("buscando cliente por id: {}", id);
		ClienteDTO cliente = clienteService.findById(id);

		return ResponseAPI.builder()
				.httpStatusCode(HttpStatus.OK.value())
				.data(cliente)
				.build();
	}

}
