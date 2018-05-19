/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unilasalle.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fabiano
 */
public class Professor {
    public long id;
    public String nome;
    public String telefone;
    public String endereco;
    public String email;
    public String registro;
    public String cpf;
    public float salario;   

    public Professor(ResultSet rs) throws SQLException {
        this.id = rs.getLong("id");
        this.nome = rs.getString("nome");
        this.telefone = rs.getString("telefone");
        this.endereco = rs.getString("endereco");
        this.email = rs.getString("email");
        this.registro = rs.getString("registro");
        this.cpf = rs.getString("cpf");
        this.salario = rs.getFloat("salario");
    }
    
    public Professor() {}
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
