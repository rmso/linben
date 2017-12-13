package com.example.samsung.linben.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Raquel on 04/07/2016.
 */
@Entity
public class Causa {

    @PrimaryKey(autoGenerate = true)
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

    public boolean validacaoTipoSanguineo(){
        boolean resultado = false;

        if (this.tipoSanguineo.equals("A+") || this.tipoSanguineo.equals("A-") || this.tipoSanguineo.equals("B+") || this.tipoSanguineo.equals("B-")
                || this.tipoSanguineo.equals("AB+") || this.tipoSanguineo.equals("AB-") || this.tipoSanguineo.equals("O-") || this.tipoSanguineo.equals("O+")){
            resultado = true;
        }

        return resultado;
    }

    public boolean validacaoCampoDoenca(){
        boolean resultado = false;
        if (!this.tipoDoenca.equals("")){
            resultado = true;
        }
        return resultado;
    }

    public boolean validacaoTodosCamposNulo (){
        boolean resultado = true;
        if(this.nome.equals("") && this.tipoDoenca.equals("")&& this.descricao.equals("")&& this.tipoSanguineo.equals("")){
            resultado = false;
        }
        return resultado;
    }
}
