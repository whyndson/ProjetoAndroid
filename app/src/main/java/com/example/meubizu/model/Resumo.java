package com.example.meubizu.model;

public class Resumo {

    private String imagem;
    private String titulo;
    private String texto;

    public Resumo(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                '}';
    }
}
