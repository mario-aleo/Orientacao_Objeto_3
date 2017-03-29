/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula3;

import java.util.Scanner;

/**
 *
 * @author l
 */
public class Aula3 {

    public static void main(String[] args) {
        AlunoDAO alunos = new AlunoDAO(10);
        
        alunos.adicionar("João", "da Silva", "001",
                2016.1, 1);
        alunos.adicionar("João", "de Souza", "002",
                2016.1, 2);
        alunos.adicionar("José", "de Souza", "003",
                2016.2, 3);
        alunos.adicionar("Maria", "Lopes", "004",
                2016.2, 1);
        alunos.adicionar("José", "Lopes", "005",
                2016.2, 2);
        alunos.adicionar("José", "Pereira", "006",
                2016.1, 2);
        alunos.adicionar("Maria", "da Penha", "007",
                2016.1, 2);
    
        alunos.atualizar("004","Maria", "Juno",
                2016.2, 1 );
        
        alunos.excluir("007");
        alunos.listar();
    }
}
