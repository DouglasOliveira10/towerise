package br.com.towerise.outbound.dao.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.towerise.core.dto.MoradorDTO;
import br.com.towerise.outbound.dao.entity.MoradorEntity;

@Service
public class MoradorMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public MoradorEntity toEntity(MoradorDTO dto) {
		return modelMapper.map(dto, MoradorEntity.class);
	}
	
	public MoradorDTO toDTO(MoradorEntity entity) {
		return modelMapper.map(entity, MoradorDTO.class);
	}
	
	public List<MoradorDTO> toListDTO(List<MoradorEntity> entitys) {
		return entitys.stream()
				.map(entity -> modelMapper.map(entity, MoradorDTO.class))
				.collect(Collectors.toList());
	}

}
