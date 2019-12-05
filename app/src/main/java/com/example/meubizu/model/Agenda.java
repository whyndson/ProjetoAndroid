package com.example.meubizu.model;

import java.io.Serializable;

public class Agenda implements Serializable {
    private long id;
    private String descricao;
    private String data;
    private String hora;

    public Agenda(){

    }
    public Agenda(String descricao, String data, String hora){
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;
    }

    public Agenda(long id, String descricao, String data, String hora){
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }



}