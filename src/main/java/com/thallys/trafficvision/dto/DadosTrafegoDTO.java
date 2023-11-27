package com.thallys.trafficvision.dto;

public class DadosTrafegoDTO  {
    private Long id;
    private Integer semana;
    private Double velocidadeMedia;
    private Integer incidentes;
    private Integer fluxo;
    private Long ruaId;

    public DadosTrafegoDTO() {
    }

    public DadosTrafegoDTO(Long id, Integer semana, Integer fluxo, Double velocidadeMedia, Integer incidentes) {
        this.id = id;
        this.semana = semana;
        this.velocidadeMedia = velocidadeMedia;
        this.incidentes = incidentes;
        this.fluxo = fluxo;
    }


    public Long getRuaId() {
        return ruaId;
    }

    public void setRuaId(Long ruaId) {
        this.ruaId = ruaId;
    }

    public Integer getFluxo() {
        return fluxo;
    }

    public void setFluxo(Integer fluxo) {
        this.fluxo = fluxo;
    }

    public Integer getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(Integer incidentes) {
        this.incidentes = incidentes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(Double velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    public Integer getSemana() {
        return semana;
    }

    public void setSemana(Integer semana) {
        this.semana = semana;
    }

}
