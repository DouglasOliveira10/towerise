package br.com.towerise.outbound.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.towerise.core.dto.AlexaWebhookDTO;
import br.com.towerise.core.port.out.AlexaDao;
import br.com.towerise.outbound.dao.entity.AlexaWebhookEntity;
import br.com.towerise.outbound.dao.mapper.AlexaWebhookMapper;
import br.com.towerise.outbound.dao.repository.AlexaWebhookRepository;
import jakarta.validation.Valid;

@Repository
public class AlexaDaoImpl implements AlexaDao {
	
	@Autowired
	private AlexaWebhookRepository alexaWebhookRepository;
	
	@Autowired
	private AlexaWebhookMapper alexaWebhookMapper;

	@Override
	public AlexaWebhookDTO cadastrarWebhookNoticacao(@Valid AlexaWebhookDTO alexaWebhookDTO) {
		var entity = alexaWebhookMapper.toEntity(alexaWebhookDTO);
		entity = alexaWebhookRepository.save(entity);
		return alexaWebhookMapper.toDTO(entity);
	}

	@Override
	public List<AlexaWebhookDTO> buscarAlexaWebhooks() {
		List<AlexaWebhookEntity> entitys = alexaWebhookRepository.findAll();
		return alexaWebhookMapper.toListDTO(entitys);
	}

	@Override
	public AlexaWebhookDTO buscarAlexaWebhooksByMoradorId(Long id) {
		var entity = alexaWebhookRepository.findByIdMorador(id);
		return alexaWebhookMapper.toDTO(entity);
	}
}
