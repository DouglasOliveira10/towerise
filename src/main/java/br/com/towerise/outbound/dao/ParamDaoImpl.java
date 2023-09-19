package br.com.towerise.outbound.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.towerise.core.dto.CondominioDTO;
import br.com.towerise.core.dto.MoradorDTO;
import br.com.towerise.core.dto.SindicoDTO;
import br.com.towerise.core.port.out.ParamDao;
import br.com.towerise.outbound.dao.entity.CondominioEntity;
import br.com.towerise.outbound.dao.entity.MoradorEntity;
import br.com.towerise.outbound.dao.entity.SindicoEntity;
import br.com.towerise.outbound.dao.mapper.CondominioMapper;
import br.com.towerise.outbound.dao.mapper.MoradorMapper;
import br.com.towerise.outbound.dao.mapper.SindicoMapper;
import br.com.towerise.outbound.dao.repository.CondominioRepository;
import br.com.towerise.outbound.dao.repository.MoradorRepository;
import br.com.towerise.outbound.dao.repository.SindicoRepository;
import jakarta.validation.Valid;

@Repository
public class ParamDaoImpl implements ParamDao {

	@Autowired
	private CondominioRepository condominioRepository;
	
	@Autowired
	private SindicoRepository sindicoRepository;
	
	@Autowired
	private MoradorRepository moradorRepository;
	
	@Autowired
	private CondominioMapper condominioMapper;
	
	@Autowired
	private SindicoMapper sindicoMapper;
	
	@Autowired
	private MoradorMapper moradorMapper;

	@Override
	public CondominioDTO cadastrarCondominio(CondominioDTO condominioDTO) {
		var entity = condominioMapper.toEntity(condominioDTO);
		entity = condominioRepository.save(entity);
		return condominioMapper.toDTO(entity);
	}

	@Override
	public List<CondominioDTO> buscarCondominios() {
		List<CondominioEntity> entitys = condominioRepository.findAll();
		return condominioMapper.toListDTO(entitys);
	}
	
	@Override
	public SindicoDTO cadastrarSindico(@Valid SindicoDTO sindicoDTO) {
		var entity = sindicoMapper.toEntity(sindicoDTO);
		entity = sindicoRepository.save(entity);
		return sindicoMapper.toDTO(entity);
	}
	
	@Override
	public List<SindicoDTO> buscarSindicos() {
		List<SindicoEntity> entitys = sindicoRepository.findAll();
		return sindicoMapper.toListDTO(entitys);
	}

	@Override
	public MoradorDTO cadastrarMorador(@Valid MoradorDTO moradorDTO) {
		var entity = moradorMapper.toEntity(moradorDTO);
		entity = moradorRepository.save(entity);
		return moradorMapper.toDTO(entity);
	}

	@Override
	public List<MoradorDTO> buscarMoradores() {
		List<MoradorEntity> entitys = moradorRepository.findAll();
		return moradorMapper.toListDTO(entitys);
	}
	
	
	
	
}
