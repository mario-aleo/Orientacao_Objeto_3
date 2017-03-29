package aula3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author l
 */
public class Aluno {
    String nome;
    String sobrenome;
    String matricula;
    double codCurso;
    int semestre;

    public Aluno(String nome, String sobrenome, 
            String matricula, double codCurso, int semestre) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
        this.codCurso = codCurso;
        this.semestre = semestre;
    }
}
