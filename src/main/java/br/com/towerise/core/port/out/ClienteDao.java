package br.com.towerise.core.port.out;

import java.util.Optional;

import br.com.towerise.core.dto.ClienteDTO;

public interface ClienteDao {
	
	Optional<ClienteDTO> findById(Long id);

}
