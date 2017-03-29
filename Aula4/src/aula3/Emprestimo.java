/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula3;

import java.util.Date;

/**
 *
 * @author Lab-H5~H7
 */
public class Emprestimo {
    int id;
    int livroId;
    String alunoMatricula;
    Date dataEmprestimo;

    public Emprestimo(int id, int livroId, String alunoMatricula,
                      Date dataEmprestimo) {
        this.id = id;
        this.livroId = livroId;
        this.alunoMatricula = alunoMatricula;
        this.dataEmprestimo = dataEmprestimo;
    }
}
