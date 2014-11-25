package com.tcc.brunopinela.model;

import android.text.format.Time;

import java.util.Date;

public class M_medicoes {
    private int id;
    private Date dia;
    private Time hora;
    private String glicose;
    private String tipoInsulina;
    private int unidades;
    private String periodo;
    private String observacoes;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getGlicose() {
        return glicose;
    }

    public void setGlicose(String glicose) {
        this.glicose = glicose;
    }

    public String getTipoInsulina() {
        return tipoInsulina;
    }

    public void setTipoInsulina(String tipoInsulina) {
        this.tipoInsulina = tipoInsulina;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
