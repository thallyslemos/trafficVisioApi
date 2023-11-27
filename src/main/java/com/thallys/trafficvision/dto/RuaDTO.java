package com.thallys.trafficvision.dto;


import java.util.List;

public class RuaDTO {
    //    rua
    private Long id;
    private String nome;
    private List<DadosTrafegoDTO> dadosTrafego; // Altere o tipo para DadosTrafegoDTO

    public RuaDTO(Long id, String nome, List<DadosTrafegoDTO> dadosTrafego) { // Altere o tipo para DadosTrafegoDTO
        this.id = id;
        this.nome = nome;
        this.dadosTrafego = dadosTrafego;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<DadosTrafegoDTO> getDadosTrafego() {
        return dadosTrafego;
    }

    public void setDadosTrafego(List<DadosTrafegoDTO> dadosTrafego) {
        this.dadosTrafego = dadosTrafego;
    }
}
