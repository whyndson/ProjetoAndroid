package com.example.meubizu.model;

import java.io.Serializable;


public class Semana implements Serializable {

    private int cod;
    private String domingo;
    private String segunda;
    private String terca;
    private String quarta;
    private String quinta;
    private String sexta;
    private String sabado;
    

    public Semana(int cod, String domingo, String segunda, String terca,String quarta,String quinta,String sexta,String sabado ) {
        this.cod = cod;
        this.domingo = domingo;
        this.segunda = segunda;
        this.terca = terca;
        this.quarta = quarta;
        this.quinta = quinta;
        this.sexta = sexta;
        this.sabado = sabado;
    }

    public String getSegunda() {
        return segunda;
    }

    public void setSegunda(String segunda) {
        this.segunda = segunda;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDomingo() {
        return domingo;
    }

    public void setDomingo(String domingo) {
        this.domingo = domingo;
    }

    public String getTerca() {
        return terca;
    }

    public void setTerca(String terca) {
        this.terca = terca;
    }
    public String getQuarta() {
        return quarta;
    }

    public void setQuarta(String quarta) {
        this.quarta = quarta;
    }

    public String getQuinta() {
        return quinta;
    }

    public void setQuinta(String quinta) {
        this.quinta = quinta;
    }

    public String getSexta() {
        return sexta;
    }

    public void setSexta(String sexta) {
        this.sexta = sexta;
    }
    public String getSabado() {
        return sabado;
    }

    public void setSabado(String sexta) {
        this.sabado = sabado;
    }

    @Override
    public String toString() {
        return "Semana" +
                "\n\nDomingo: " + domingo +
                "\n\nSegunda: " + segunda +
                "\n\nTerca: " + terca +
                "\n\nQuarta: " + quarta +
                "\n\nQuinta: " + quinta +
                "\n\nSexta: " + sexta +
                "\n\nSabado: " + sabado
                ;
    }
}
