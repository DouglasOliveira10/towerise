package br.com.towerise.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.towerise.core.dto.CondominioDTO;
import br.com.towerise.core.dto.MoradorDTO;
import br.com.towerise.core.dto.SindicoDTO;
import br.com.towerise.core.exception.ParamException;
import br.com.towerise.core.port.in.ParamService;
import br.com.towerise.core.port.out.ParamDao;
import jakarta.validation.Valid;

@Service
public class ParamServiceImpl implements ParamService {
	
	@Autowired
	private ParamDao paramDao;
	
	@Override
	public CondominioDTO cadastrarCondominio(CondominioDTO condominioDTO) throws ParamException {
		return paramDao.cadastrarCondominio(condominioDTO);
	}

	@Override
	public List<CondominioDTO> buscarCondominios() throws ParamException {
		return paramDao.buscarCondominios();
	}

	@Override
	public SindicoDTO cadastrarSindico(@Valid SindicoDTO sindicoDTO) throws ParamException {
		return paramDao.cadastrarSindico(sindicoDTO);
	}

	@Override
	public List<SindicoDTO> buscarSindicos() throws ParamException {
		return paramDao.buscarSindicos();
	}

	@Override
	public MoradorDTO cadastrarMorador(@Valid MoradorDTO moradorDTO) throws ParamException {
		return paramDao.cadastrarMorador(moradorDTO);
	}

	@Override
	public List<MoradorDTO> buscarMoradores() throws ParamException {
		return paramDao.buscarMoradores();
	}

}
