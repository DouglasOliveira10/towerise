package br.com.towerise.outbound.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.towerise.outbound.dao.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

}
