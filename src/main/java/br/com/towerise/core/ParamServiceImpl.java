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
	public SindicoDTO cadastrarSindico(@Valid SindicoDTO sindicoDTO) {
		return paramDao.cadastrarSindico(sindicoDTO);
	}

	@Override
	public List<SindicoDTO> buscarSindicos() {
		return paramDao.buscarSindicos();
	}

	@Override
	public MoradorDTO cadastrarmorador(@Valid MoradorDTO moradorDTO) {
		return paramDao.cadastrarMorador(moradorDTO);
	}

	@Override
	public List<MoradorDTO> buscarMoradores() {
		return paramDao.buscarMoradores();
	}

}
