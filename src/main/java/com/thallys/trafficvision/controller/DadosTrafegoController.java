package com.thallys.trafficvision.controller;


import com.thallys.trafficvision.dto.DadosTrafegoDTO;
import com.thallys.trafficvision.model.DadosTrafego;
import com.thallys.trafficvision.service.DadosTrafegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dados-trafego")
public class DadosTrafegoController {

    @Autowired
    private DadosTrafegoService dadosTrafegoService;

    @GetMapping
    public List<DadosTrafego> getAll() {
        return dadosTrafegoService.getAll();
    }

    @GetMapping("/{id}")
    public DadosTrafego getById(@PathVariable Long id) {
        return dadosTrafegoService.getById(id);
    }

    @GetMapping("/rua/{id}")
    public List<DadosTrafego> getByRuaId(@PathVariable Long id) {
        return dadosTrafegoService.getByRuaId(id);
    }

    @PostMapping
    public DadosTrafego save(@RequestBody DadosTrafegoDTO dadosTrafego) {
        return dadosTrafegoService.save(dadosTrafego);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        dadosTrafegoService.delete(id);
    }

    @PutMapping("/{id}")
    public DadosTrafego update(@PathVariable Long id, @RequestBody DadosTrafegoDTO dadosTrafego) {
        return dadosTrafegoService.update(id, dadosTrafego);
    }
}
