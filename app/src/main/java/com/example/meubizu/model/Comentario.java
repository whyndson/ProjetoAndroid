package com.example.meubizu.model;

import java.io.Serializable;

public class Comentario implements Serializable {

    private int id;
    private String nome, cep, cidade, estado, conteudo;

    public Comentario(int id, String nome, String cep, String cidade, String estado, String conteudo) {
        this.id = id;
        this.nome = nome;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.conteudo = conteudo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "Usuário: " + nome  +
        "\nCidade: " + cidade  +
        "\nEstado: " + estado +
        "\n\nComentário: " + conteudo+"\n";
    }



}