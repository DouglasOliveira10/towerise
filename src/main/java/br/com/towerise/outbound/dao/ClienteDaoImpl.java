package br.com.towerise.outbound.dao;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.towerise.core.dto.ClienteDTO;
import br.com.towerise.core.port.out.ClienteDao;
import br.com.towerise.outbound.dao.entity.ClienteEntity;
import br.com.towerise.outbound.dao.repository.ClienteRepository;

@Repository
public class ClienteDaoImpl implements ClienteDao {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Optional<ClienteDTO> findById(Long id) {
		Optional<ClienteEntity> entity = clienteRepository.findById(id);
		return entity.map(this::toClienteDTO);
	}

	private ClienteDTO toClienteDTO(ClienteEntity entity) {
		return modelMapper.map(entity, ClienteDTO.class);
	}
}
