package br.com.towerise.outbound.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.towerise.outbound.dao.entity.AlexaWebhookEntity;

public interface AlexaWebhookRepository extends JpaRepository<AlexaWebhookEntity, Long> {

}
