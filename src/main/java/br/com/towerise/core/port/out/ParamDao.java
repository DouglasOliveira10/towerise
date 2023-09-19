package br.com.towerise.core.port.out;

import java.util.List;

import br.com.towerise.core.dto.CondominioDTO;
import br.com.towerise.core.dto.MoradorDTO;
import br.com.towerise.core.dto.SindicoDTO;
import jakarta.validation.Valid;

public interface ParamDao {
	
	CondominioDTO cadastrarCondominio(CondominioDTO condominioDTO);

	List<CondominioDTO> buscarCondominios();

	SindicoDTO cadastrarSindico(@Valid SindicoDTO sindicoDTO);

	List<SindicoDTO> buscarSindicos();

	MoradorDTO cadastrarMorador(@Valid MoradorDTO moradorDTO);

	List<MoradorDTO> buscarMoradores();

}
