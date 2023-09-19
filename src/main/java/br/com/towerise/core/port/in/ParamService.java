package br.com.towerise.core.port.in;

import java.util.List;

import br.com.towerise.core.dto.CondominioDTO;
import br.com.towerise.core.dto.MoradorDTO;
import br.com.towerise.core.dto.SindicoDTO;
import br.com.towerise.core.exception.ParamException;
import jakarta.validation.Valid;

public interface ParamService {

	CondominioDTO cadastrarCondominio(CondominioDTO condominioDTO) throws ParamException;

	List<CondominioDTO> buscarCondominios() throws ParamException;

	SindicoDTO cadastrarSindico(@Valid SindicoDTO sindicoDTO);

	List<SindicoDTO> buscarSindicos();

	MoradorDTO cadastrarmorador(@Valid MoradorDTO moradorDTO);

	List<MoradorDTO> buscarMoradores();
}
