package br.com.towerise.outbound.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.towerise.outbound.dao.entity.CondominioEntity;

public interface CondominioRepository extends JpaRepository<CondominioEntity, Long> {

}
