package br.com.towerise.core.port.in;

import br.com.towerise.core.exception.NotificationException;

public interface NotificationService {

	void notificarVisitante(Long id) throws NotificationException;

}
