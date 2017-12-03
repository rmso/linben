package com.example.samsung.linben.models;

/**
 * Created by Samsung on 09/11/2017.
 */

public class Hemocentro {

    private String nome;
    private String descricao;
    private String site;

    public Hemocentro(String nome, String descricao, String site) {
        this.nome = nome;
        this.descricao = descricao;
        this.site = site;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }


}
