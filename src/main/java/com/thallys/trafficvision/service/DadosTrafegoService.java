package com.thallys.trafficvision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thallys.trafficvision.dto.DadosTrafegoDTO;
import com.thallys.trafficvision.model.DadosTrafego;
import com.thallys.trafficvision.model.Rua;
import com.thallys.trafficvision.repository.DadosTrafegoRepository;

//mapsctruct
@Service
public class DadosTrafegoService {

    @Autowired
    private DadosTrafegoRepository dadosTrafegoRepository;

    @Autowired
    private RuaService ruaService;

    public List<DadosTrafego> getAll() {
        return dadosTrafegoRepository.findAll();
    }

    public DadosTrafego getById(Long id) {
        return dadosTrafegoRepository.findById(id).orElse(null);
    }

    public List<DadosTrafego> getByRuaId(Long id) {
        return dadosTrafegoRepository.findByRuaId(id);
    }

    public DadosTrafego save(DadosTrafegoDTO dadosTrafego) {
        Rua rua = ruaService.getById(dadosTrafego.getRuaId());

        if (dadosTrafegoRepository.existsByRuaIdAndSemana(rua.getId(), dadosTrafego.getSemana())) {
            throw new RuntimeException("Essa rua já possui dados da semana " + dadosTrafego.getSemana());
        }

        DadosTrafego dadosTrafegoToSave = new DadosTrafego();
        dadosTrafegoToSave.setSemana(dadosTrafego.getSemana());
        dadosTrafegoToSave.setVelocidadeMedia(dadosTrafego.getVelocidadeMedia());
        dadosTrafegoToSave.setIncidentes(dadosTrafego.getIncidentes());
        dadosTrafegoToSave.setFluxo(dadosTrafego.getFluxo());
        dadosTrafegoToSave.setRua(rua);

        return dadosTrafegoRepository.save(dadosTrafegoToSave);
    }

    public void delete(Long id) {
        dadosTrafegoRepository.deleteById(id);
    }

    public DadosTrafego update(Long id, DadosTrafegoDTO dadosTrafego) {
        DadosTrafego dadosTrafegoToUpdate = dadosTrafegoRepository.findById(id).orElse(null);
        if (dadosTrafegoToUpdate == null) {
            throw new RuntimeException("Dados não encontrados");
        }
        dadosTrafegoToUpdate.setIncidentes(dadosTrafego.getIncidentes());
        dadosTrafegoToUpdate.setVelocidadeMedia(dadosTrafego.getVelocidadeMedia());
        dadosTrafegoToUpdate.setSemana(dadosTrafego.getSemana());
        dadosTrafegoToUpdate.setFluxo(dadosTrafego.getFluxo());

        return dadosTrafegoRepository.save(dadosTrafegoToUpdate);
    }

}
