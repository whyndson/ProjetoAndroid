package com.example.meubizu.model;

public class Materia {

    private long id;
    private String nome;

    public Materia(String nome) {
        this.nome = nome;
        this.id = Rascunho.getIdDeUmaMateria(nome);
    }

    public Materia(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
