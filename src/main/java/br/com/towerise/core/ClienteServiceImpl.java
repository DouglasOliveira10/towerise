package br.com.towerise.core;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.towerise.core.dto.ClienteDTO;
import br.com.towerise.core.exception.ClienteException;
import br.com.towerise.core.port.in.ClienteService;
import br.com.towerise.core.port.out.ClienteDao;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	public ClienteDTO findById(Long id) throws ClienteException {
		Optional<ClienteDTO> cliente = clienteDao.findById(id);
		
		if (!cliente.isPresent())
			throw new ClienteException("Cliente não encontrado!");
		
		return cliente.get();
	}

}
