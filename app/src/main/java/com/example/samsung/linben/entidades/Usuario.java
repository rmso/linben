package com.example.samsung.linben.entidades;

import java.util.Date;

/**
 * Created by Samsung on 01/07/2016.
 */
public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private String tipo_sanguineo;
    private String genero;
    private String data_nascimento;

    public  Usuario (){

    }

    public int getId() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo_sanguineo() {
        return tipo_sanguineo;
    }

    public void setTipo_sanguineo(String tipo_sanguineo) {
        this.tipo_sanguineo = tipo_sanguineo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String toString(){
        return "ID: " +id+ " Nome: " +nome+ " Email: " +email+ " Senha: " +senha+ " Tipo Sanguíneo: " +tipo_sanguineo+ " Gênero: " +genero+ " Data de Nascimento: " +data_nascimento;
    }

}
