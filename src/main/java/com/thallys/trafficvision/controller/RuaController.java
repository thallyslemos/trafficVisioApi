package com.thallys.trafficvision.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thallys.trafficvision.dto.RuaDTO;
import com.thallys.trafficvision.model.Rua;
import com.thallys.trafficvision.service.DashboardService;
import com.thallys.trafficvision.service.RuaService;

@RestController
@RequestMapping("/ruas")
public class RuaController {

    @Autowired
    private RuaService ruaService;
    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public List<Rua> getAll() {
        return ruaService.getAll();
    }

    @GetMapping("/{id}")
    public Rua getById(@PathVariable Long id) {
        return ruaService.getById(id);
    }

    @GetMapping("/dados")
    public List<RuaDTO> getWithData() {
        return dashboardService.getAllData();
    }

    @PostMapping
    public Rua save(@RequestBody Rua rua) {
        return ruaService.save(rua);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ruaService.delete(id);
    }

    @PutMapping("/{id}")
    public Rua update(@PathVariable Long id, @RequestBody Rua rua) {
        return ruaService.update(id, rua);
    }
}