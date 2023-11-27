package com.thallys.trafficvision.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thallys.trafficvision.dto.DadosTrafegoDTO;
import com.thallys.trafficvision.dto.RuaDTO;
import com.thallys.trafficvision.model.DadosTrafego;
import com.thallys.trafficvision.model.Rua;
import com.thallys.trafficvision.repository.DadosTrafegoRepository;
import com.thallys.trafficvision.repository.RuaRepository;

@Service
public class DashboardService {
    
    @Autowired
    private RuaRepository ruaRepository;
    @Autowired
    private DadosTrafegoRepository dadosTrafegoRepository;

        public List<RuaDTO> getAllData() {
        List<Rua> ruas = ruaRepository.findAll();
        Map<Long, RuaDTO> ruaDTOMap = new HashMap<>();

        for (Rua rua : ruas) {
            RuaDTO ruaDTO = ruaDTOMap.getOrDefault(rua.getId(), new RuaDTO(rua.getId(), rua.getNome(), new ArrayList<>()));
            for (DadosTrafego dadosTrafego : dadosTrafegoRepository.findByRuaId(rua.getId())) {
                DadosTrafegoDTO dadosTrafegoDTO = new DadosTrafegoDTO(dadosTrafego.getId(), dadosTrafego.getSemana(), dadosTrafego.getFluxo(), dadosTrafego.getVelocidadeMedia(), dadosTrafego.getIncidentes());
                ruaDTO.getDadosTrafego().add(dadosTrafegoDTO);
            }
            ruaDTOMap.put(rua.getId(), ruaDTO);
        }

        return new ArrayList<>(ruaDTOMap.values());
    }
}
