package br.com.towerise.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.towerise.core.dto.AlexaWebhookDTO;
import br.com.towerise.core.port.in.AlexaService;
import br.com.towerise.core.port.out.AlexaDao;
import jakarta.validation.Valid;

@Service
public class AlexaServiceImpl implements AlexaService {
	
	@Autowired
	private AlexaDao alexaDao;

	@Override
	public AlexaWebhookDTO cadastrarAlexaWebhook(@Valid AlexaWebhookDTO alexaWebhookDTO) {
		return alexaDao.cadastrarWebhookNoticacao(alexaWebhookDTO);
	}

	@Override
	public List<AlexaWebhookDTO> buscarAlexaWebhooks() {
		return alexaDao.buscarAlexaWebhooks();
	}

}
