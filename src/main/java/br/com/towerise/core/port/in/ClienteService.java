package br.com.towerise.core.port.in;

import br.com.towerise.core.dto.ClienteDTO;
import br.com.towerise.core.exception.ClienteException;

public interface ClienteService {

	ClienteDTO findById(Long id) throws ClienteException;
}
