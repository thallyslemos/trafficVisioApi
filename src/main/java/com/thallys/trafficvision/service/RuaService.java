package com.thallys.trafficvision.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thallys.trafficvision.model.Rua;
import com.thallys.trafficvision.repository.RuaRepository;

@Service
public class RuaService {

    @Autowired
    private RuaRepository ruaRepository;

    public List<Rua> getAll() {
        return ruaRepository.findAll();
    }

    public Rua getById(Long id) {
        return ruaRepository.findById(id).orElse(null);
    }

    public Rua save(Rua rua) {
        return ruaRepository.save(rua);
    }

    public void delete(Long id) {
        ruaRepository.deleteById(id);
    }

    public Rua update(Long id, Rua rua) {
        Rua ruaToUpdate = ruaRepository.findById(id).orElse(null);
        ruaToUpdate.setNome(rua.getNome());
        return ruaRepository.save(ruaToUpdate);
    }

}