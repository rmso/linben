package com.example.samsung.linben.models;

/**
 * Created by Raquel on 04/07/2016.
 */
public class Causa {

    private int id;
    private String descricao;
    private String nome;
    private String tipoSanguineo;
    private String tipoDoenca;

    public Causa (){
    }

    public Causa(String descricao, String nome, String tipoSanguineo, String tipoDoenca){
        this.nome = nome;
        this.descricao = descricao;
        this.tipoSanguineo = tipoSanguineo;
        this.tipoDoenca = tipoDoenca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getTipoDoenca() {
        return tipoDoenca;
    }

    public void setTipoDoenca(String tipoDoenca) {
        this.tipoDoenca = tipoDoenca;
    }

    public String toString(){
        return " Descrição: " +descricao + "Nome: " +nome + "Tipo Sanguineo: " +tipoSanguineo + "Tipo de Doença:" + tipoDoenca;
    }

}
