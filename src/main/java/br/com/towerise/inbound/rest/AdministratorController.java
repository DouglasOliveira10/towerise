package br.com.towerise.inbound.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.towerise.core.dto.CondominioDTO;
import br.com.towerise.core.dto.SindicoDTO;
import br.com.towerise.core.exception.ParamException;
import br.com.towerise.core.port.in.ParamService;
import br.com.towerise.inbound.rest.responses.ResponseAPI;
import br.com.towerise.inbound.rest.responses.ResponseItems;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/administracao")
public class AdministratorController {

	@Autowired
	private ParamService paramService;

	@PostMapping("/condominio")
	@ResponseStatus(HttpStatus.OK)
	public ResponseAPI cadastrarCondominio(@Valid @RequestBody CondominioDTO condominioDTO) throws ParamException {
		log.info("Cadastrando novo condominio: {}", condominioDTO);
		var dtoSalvo = paramService.cadastrarCondominio(condominioDTO);

		return ResponseAPI.builder()
				.httpStatusCode(HttpStatus.OK.value())
				.data(dtoSalvo)
				.build();
	}
	
	@GetMapping("/condominio")
	public ResponseAPI buscarCondominios() throws ParamException {
		log.info("Buscando condominios cadastrados}");
		var listaDto = paramService.buscarCondominios();
		
		var items = ResponseItems.builder()
				.items(listaDto)
				.build();
		
		return ResponseAPI.builder()
				.httpStatusCode(HttpStatus.OK.value())
				.data(items)
				.build();
	}
	
	@PostMapping("/sindico")
	@ResponseStatus(HttpStatus.OK)
	public ResponseAPI cadastrarSindico(@Valid @RequestBody SindicoDTO sindicoDTO) throws ParamException {
		log.info("Cadastrando novo sindico: {}", sindicoDTO);
		var dtoSalvo = paramService.cadastrarSindico(sindicoDTO);

		return ResponseAPI.builder()
				.httpStatusCode(HttpStatus.OK.value())
				.data(dtoSalvo)
				.build();
	}
	
	@GetMapping("/sindico")
	public ResponseAPI buscarSindicos() throws ParamException {
		log.info("Buscando sindicos cadastrados}");
		var listaDto = paramService.buscarSindicos();
		
		var items = ResponseItems.builder()
				.items(listaDto)
				.build();
		
		return ResponseAPI.builder()
				.httpStatusCode(HttpStatus.OK.value())
				.data(items)
				.build();
	}

}
