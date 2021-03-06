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
public class Disciplina {

    public Disciplina(ResultSet rs) throws SQLException {
        this.id = rs.getLong("id");
        this.nome = rs.getString("nome");
        this.codigo = rs.getString("codigo");
        this.id_professor = rs.getLong("id_professor");
        this.cargaHoraria = rs.getLong("cargaHoraria");
    }

    public Disciplina() {
    }

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public long getId_professor() {
        return id_professor;
    }

    public void setId_professor(long id_professor) {
        this.id_professor = id_professor;
    }

    public long getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(long cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public long id;
    public String nome;
    public String codigo;
    public long id_professor;
    public long cargaHoraria;
}
