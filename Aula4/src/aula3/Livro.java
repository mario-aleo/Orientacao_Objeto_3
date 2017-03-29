/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula3;

/**
 *
 * @author Lab-H5~H7
 */
public class Livro {
    int id;
    String nome;
    String autor;
    int edicao;
    double categoria;
    String isbn;

    public Livro(int id, String nome, String autor, int edicao,
                 double categoria, String isbn) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.edicao = edicao;
        this.categoria = categoria;
        this.isbn = isbn;
    }
}