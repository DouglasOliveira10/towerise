package br.com.towerise.outbound.dao.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.towerise.core.dto.AlexaWebhookDTO;
import br.com.towerise.outbound.dao.entity.AlexaWebhookEntity;

@Service
public class AlexaWebhookMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public AlexaWebhookEntity toEntity(AlexaWebhookDTO dto) {
		return modelMapper.map(dto, AlexaWebhookEntity.class);
	}
	
	public AlexaWebhookDTO toDTO(AlexaWebhookEntity entity) {
		return modelMapper.map(entity, AlexaWebhookDTO.class);
	}
	
	public List<AlexaWebhookDTO> toListDTO(List<AlexaWebhookEntity> entitys) {
		return entitys.stream()
				.map(entity -> modelMapper.map(entity, AlexaWebhookDTO.class))
				.collect(Collectors.toList());
	}

}
