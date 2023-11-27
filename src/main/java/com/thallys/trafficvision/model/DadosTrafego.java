package com.thallys.trafficvision.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"rua_id", "semana"})})
public class DadosTrafego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer semana;
    @Column(nullable = false)
    private Double velocidadeMedia;
    @Column(nullable = false)
    private Integer incidentes;
    @Column(nullable = false)
    private Integer fluxo;

    @ManyToOne
    @JoinColumn(nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Rua rua;

    public Integer getFluxo() {
        return fluxo;
    }

    public void setFluxo(Integer fluxo) {
        this.fluxo = fluxo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSemana() {
        return semana;
    }

    public void setSemana(Integer semana) {
        this.semana = semana;
    }

    public Double getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(Double velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    public Integer getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(Integer incidentes) {
        this.incidentes = incidentes;
    }

    public Rua getRua() {
        return rua;
    }

    public void setRua(Rua rua) {
        this.rua = rua;
    }
}