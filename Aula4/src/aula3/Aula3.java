/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula3;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author l
 */
public class Aula3 {

    public static void main(String[] args) {
        AlunoJDBC alunos = new AlunoJDBC(); 
        LivroDAO livros = new LivroDAO();
        EmprestimoDAO emprestimos = new EmprestimoDAO();
        
        alunos.save("João", "de Souza", "001", 2016.1, 1);
        alunos.save("José", "de Souza", "002", 2016.2, 2);
        alunos.save("Maria", "Lopes", "003", 2016.2, 3);
        alunos.save("Jaz", "Saxx", "004", 2016.2, 3);
        alunos.list();
    
        alunos.update("003","Maria", "Juno", 2016.2, 1 );
        alunos.searchByMatricula("003");
        
        alunos.delete("004");
        alunos.list();
        
        
        livros.create("C Completo e Total", "J. Souza", 1, 1.0,
                      "1234567891234");
        livros.create("Fisica III", "Sears Zemansk", 3, 2.3, "2345678912345");
        livros.create("Calculo Diferencial Integral", "M. Jones", 2, 3.0,
                      "3456789123456");
        livros.create("Fisica", "R. Guliard", 1, 2.1, "4567891234567");
        livros.getAllBooks();
    
        livros.update(4, "Fisica", "T. Gulliard", 1, 2.1, "4567891234567");
        livros.searchByName("Fisica");
        
        livros.delete(4);
        livros.getAllBooks();
        
        //Emprestimo(int id, int livroId, String alunoMatricula, Date dataEmprestimo)
        emprestimos.create(1, "003", new Date());
        emprestimos.create(2, "001", new Date());
        emprestimos.create(3, "002", new Date());
        emprestimos.getAllEmprestimos();
        
        emprestimos.update(1, 1, "002", new Date());
        emprestimos.searchByStudent("002");
        
        livros.delete(2);
        livros.getAllBooks();
    }
}
