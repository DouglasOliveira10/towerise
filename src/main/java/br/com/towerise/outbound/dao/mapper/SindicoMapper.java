package br.com.towerise.outbound.dao.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.towerise.core.dto.SindicoDTO;
import br.com.towerise.outbound.dao.entity.SindicoEntity;

@Service
public class SindicoMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public SindicoEntity toEntity(SindicoDTO dto) {
		return modelMapper.map(dto, SindicoEntity.class);
	}
	
	public SindicoDTO toDTO(SindicoEntity entity) {
		return modelMapper.map(entity, SindicoDTO.class);
	}
	
	public List<SindicoDTO> toListDTO(List<SindicoEntity> entitys) {
		return entitys.stream()
				.map(entity -> modelMapper.map(entity, SindicoDTO.class))
				.collect(Collectors.toList());
	}

}
