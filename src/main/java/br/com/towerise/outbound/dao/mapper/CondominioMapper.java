package br.com.towerise.outbound.dao.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.towerise.core.dto.CondominioDTO;
import br.com.towerise.outbound.dao.entity.CondominioEntity;

@Service
public class CondominioMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CondominioEntity toEntity(CondominioDTO dto) {
		return modelMapper.map(dto, CondominioEntity.class);
	}
	
	public CondominioDTO toDTO(CondominioEntity entity) {
		return modelMapper.map(entity, CondominioDTO.class);
	}
	
	public List<CondominioDTO> toListDTO(List<CondominioEntity> entitys) {
		return entitys.stream()
				.map(entity -> modelMapper.map(entity, CondominioDTO.class))
				.collect(Collectors.toList());
	}

}
