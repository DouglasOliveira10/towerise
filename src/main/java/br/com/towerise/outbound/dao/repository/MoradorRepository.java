package br.com.towerise.outbound.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.towerise.outbound.dao.entity.MoradorEntity;

public interface MoradorRepository extends JpaRepository<MoradorEntity, Long> {

}
