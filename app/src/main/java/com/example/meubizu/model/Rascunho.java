package com.example.meubizu.model;

import java.io.Serializable;

public class Rascunho implements Serializable {

    public static final int ID_BIOLOGIA         = 1;
    public static final int ID_ESPANHOL         = 2;
    public static final int ID_FILOSOFIA        = 3;
    public static final int ID_FISICA           = 4;
    public static final int ID_GEOGRAFIA        = 5;
    public static final int ID_HISTORIA         = 6;
    public static final int ID_INGLES           = 7;
    public static final int ID_MATEMATICA       = 8;
    public static final int ID_PORTUGUES        = 9;
    public static final int ID_REDACAO          = 10;
    public static final int ID_QUIMICA          = 11;
    public static final int ID_SOCIOLOGIA       = 12;


    private String imagem;
    private String titulo;
    private String texto;
    private long id;
    private long id_materia;
    private String dataDeCriacao;
    private String foto;



    public Rascunho(String titulo, String texto, String materia, String dataDeCriacao, String foto) {
        this.titulo = titulo;
        this.texto = texto;
        this.dataDeCriacao = dataDeCriacao;
        setId_materiaPorNome(materia);
        this.foto = foto;
    }
    public Rascunho(String titulo, String texto, long id_materia,String dataDeCriacao, String foto) {
        this.titulo = titulo;
        this.texto = texto;
        this.id_materia = id_materia;
        this.dataDeCriacao = dataDeCriacao;
        this.foto = foto;
    }
    public Rascunho(String titulo, String texto, long id_materia,long id, String dataDeCriacao, String foto) {
        this.titulo = titulo;
        this.texto = texto;
        this.id_materia = id_materia;
        this.dataDeCriacao = dataDeCriacao;
        this.id = id;
        this.foto = foto;
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


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_materia() {
        return id_materia;
    }

    public void setId_materia(long id_materia) {
        this.id_materia = id_materia;
    }

    public static long getIdDeUmaMateria(String materia){
        long retorno = 0;
        if(materia.equalsIgnoreCase("biologia")){
            retorno = ID_BIOLOGIA;
        }else if(materia.equalsIgnoreCase("espanhol")){
            retorno = ID_ESPANHOL;
        }else if(materia.equalsIgnoreCase("filosofia")){
            retorno = ID_FILOSOFIA;
        }else if(materia.equalsIgnoreCase("física")){
            retorno = ID_FISICA;
        }else if(materia.equalsIgnoreCase("geografia")){
            retorno = ID_GEOGRAFIA;
        }else if(materia.equalsIgnoreCase("história")){
            retorno = ID_HISTORIA;
        }else if(materia.equalsIgnoreCase("inglês")){
            retorno = ID_INGLES;
        }else if(materia.equalsIgnoreCase("matemática")){
            retorno = ID_MATEMATICA;
        }else if(materia.equalsIgnoreCase("português")){
            retorno = ID_PORTUGUES;
        }else if(materia.equalsIgnoreCase("redação")){
            retorno = ID_REDACAO;
        }else if(materia.equalsIgnoreCase("química")){
            retorno = ID_QUIMICA;
        }else if(materia.equalsIgnoreCase("sociologia")){
            retorno = ID_SOCIOLOGIA;
        }else{
            retorno = 0;
        }
        return retorno;
    }

    public long setId_materiaPorNome(String materia){
        this.id_materia = getIdDeUmaMateria(materia);
        return this.id_materia;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(String dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                '}';
    }
}
