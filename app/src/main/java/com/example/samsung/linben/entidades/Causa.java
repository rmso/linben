package com.example.samsung.linben.entidades;

/**
 * Created by Raquel on 04/07/2016.
 */
public class Causa {

    private int id;
    private String descricao;
    private String estado;
    private String cidade;
    private String hemocentro;
    private String nome;

    public Causa (){
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getHemocentro() {
        return hemocentro;
    }

    public void setHemocentro(String hemocentro) {
        this.hemocentro = hemocentro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String toString(){
        return "Nome: "+nome+"Hemocentro: " +hemocentro+ " Cidade: " +cidade+ " Estado: " +estado + " Descrição: " +descricao;
    }

}
