/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unilasalle.entity;

/**
 *
 * @author fabiano
 */
public class Nota {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    public long getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(long id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public long getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(long id_aluno) {
        this.id_aluno = id_aluno;
    }
    public long id;
    public float nota1;
    public float nota2;
    public float nota3;
    public long id_disciplina;
    public long id_aluno;
}
