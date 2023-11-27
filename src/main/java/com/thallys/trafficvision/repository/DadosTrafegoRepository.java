package com.thallys.trafficvision.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thallys.trafficvision.model.DadosTrafego;

public interface DadosTrafegoRepository extends JpaRepository<DadosTrafego, Long> {
    List<DadosTrafego> findByRuaId(Long id);
    Boolean existsByRuaIdAndSemana(Long id, Integer semana);
}